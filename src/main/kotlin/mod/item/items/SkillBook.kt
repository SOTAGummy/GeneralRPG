package mod.item.items

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import mod.Core
import mod.item.baseitem.GeneralRPGItem
import mod.item.baseitem.ItemSkill
import net.minecraft.client.resources.I18n
import net.minecraft.client.util.ITooltipFlag
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.EnumAction
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.util.ActionResult
import net.minecraft.util.EnumActionResult
import net.minecraft.util.EnumHand
import net.minecraft.util.ResourceLocation
import net.minecraft.util.text.TextFormatting
import net.minecraft.world.World


object SkillBook : GeneralRPGItem() {
	init {
		this.unlocalizedName = "skillbook"
		this.creativeTab = Core.creativeaTab
		this.maxStackSize = 1
		this.registryName = ResourceLocation(Core.ID, "skillbook")
	}

	override fun addInformation(stack: ItemStack, worldIn: World?, tooltip: MutableList<String>, flagIn: ITooltipFlag) {
		super.addInformation(stack, worldIn, tooltip, flagIn)
		var cost = 0
		repeat(5) {
			if (stack.tagCompound != null && stack.tagCompound!!.getInteger(it.toString()) != 0) {
				val format = I18n.format(ItemStack(getItemById(stack.tagCompound!!.getInteger(it.toString()))).displayName)
				val item = (getItemById(stack.tagCompound!!.getInteger(it.toString()))) as ItemSkill
				val color = item.rarity.colorChar

				cost += item.cost
				tooltip.add("$it : $color${TextFormatting.UNDERLINE}$format")
			}
		}
		if (stack.tagCompound != null) {
			tooltip.add(cost.toString() + "MP")
		}

	}

	override fun onItemRightClick(world: World, player: EntityPlayer, handIn: EnumHand): ActionResult<ItemStack> {
		val itemstack = player.getHeldItem(handIn)
		player.activeHand = handIn
		if (itemstack.tagCompound != null) {
			GlobalScope.launch {
				repeat(5) {
					if (itemstack.tagCompound!!.getInteger(it.toString()) != 0) {
						val item = (getItemById(itemstack.tagCompound!!.getInteger(it.toString()))) as ItemSkill
						item.skillFunction(world, player, handIn)
						delay(500)
					}
				}
			}
		}
		return ActionResult(EnumActionResult.SUCCESS, itemstack)
	}

	override fun getItemUseAction(stack: ItemStack): EnumAction {
		return EnumAction.BLOCK
	}

	override fun onCreated(stack: ItemStack, worldIn: World, playerIn: EntityPlayer) {
		val nbt = NBTTagCompound()
		stack.tagCompound = nbt
	}
}