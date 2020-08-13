package mod.item.items

import mod.Core
import mod.item.baseitem.GeneralRPGItem
import mod.item.skill.SkillFunctions
import net.minecraft.client.util.ITooltipFlag
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.EnumAction
import net.minecraft.item.ItemStack
import net.minecraft.util.ActionResult
import net.minecraft.util.EnumActionResult
import net.minecraft.util.EnumHand
import net.minecraft.util.ResourceLocation
import net.minecraft.world.World


object SkillBook : GeneralRPGItem() {
	init {
		this.unlocalizedName = "skillbook"
		this.creativeTab = Core.creativeaTab
		this.maxStackSize = 1
		this.registryName = ResourceLocation(Core.ID, "skillbook")
		this.addPropertyOverride(ResourceLocation("blocking")) { stack, worldIn, entityIn -> if (entityIn != null && entityIn.isHandActive && entityIn.activeItemStack == stack) 1.0f else 0.0f }
	}

	override fun addInformation(stack: ItemStack, worldIn: World?, tooltip: MutableList<String>, flagIn: ITooltipFlag) {
		super.addInformation(stack, worldIn, tooltip, flagIn)
		if (stack.tagCompound != null && stack.tagCompound!!.getInteger("1") != null) {
			tooltip.add(ItemStack(getItemById(stack.tagCompound!!.getInteger("1"))).displayName)
		}
		if (stack.tagCompound != null && stack.tagCompound!!.getInteger("2") != null) {
			tooltip.add(ItemStack(getItemById(stack.tagCompound!!.getInteger("2"))).displayName)
		}
	}

	override fun onItemRightClick(world: World, player: EntityPlayer, handIn: EnumHand): ActionResult<ItemStack> {
		val itemstack = player.getHeldItem(handIn)
		player.activeHand = handIn
		if (itemstack.tagCompound != null) {
			repeat(4){
				if (itemstack.tagCompound!!.getInteger(it.toString()) != null) {
					val name = getItemById(itemstack.tagCompound!!.getInteger(it.toString())).unlocalizedName.split(".")[1]
					SkillFunctions.valueOf(name.toUpperCase()).SkillFunction(world, player, handIn)
					Thread.sleep(1000)
				}
			}
		}
		return ActionResult(EnumActionResult.SUCCESS, itemstack)
	}

	override fun getItemUseAction(stack: ItemStack): EnumAction {
		return EnumAction.BLOCK
	}
}