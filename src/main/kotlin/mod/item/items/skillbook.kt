package mod.item.items

import mod.Core
import mod.item.baseitem.GeneralRPGItem
import mod.item.skill.SkillFunctionTask
import mod.item.skill.SkillFunctions
import net.minecraft.client.util.ITooltipFlag
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.EnumAction
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.util.*
import net.minecraft.world.World
import java.util.Timer


object SkillBook : GeneralRPGItem() {
	val time: Timer = Timer()

	init {
		this.unlocalizedName = "skillbook"
		this.creativeTab = Core.creativeaTab
		this.maxStackSize = 1
		this.registryName = ResourceLocation(Core.ID, "skillbook")
		this.addPropertyOverride(ResourceLocation("blocking")) { stack, worldIn, entityIn -> if (entityIn != null && entityIn.isHandActive && entityIn.activeItemStack == stack) 1.0f else 0.0f }
	}

	override fun addInformation(stack: ItemStack, worldIn: World?, tooltip: MutableList<String>, flagIn: ITooltipFlag) {
		super.addInformation(stack, worldIn, tooltip, flagIn)
		repeat (5) {
			if (stack.tagCompound != null && stack.tagCompound!!.getInteger(it.toString()) != 0) {
				tooltip.add(it.toString() + " : " + ItemStack(getItemById(stack.tagCompound!!.getInteger(it.toString()))).displayName)
			}
		}
	}

	override fun onItemRightClick(world: World, player: EntityPlayer, handIn: EnumHand): ActionResult<ItemStack> {
		val itemstack = player.getHeldItem(handIn)
		player.activeHand = handIn
		if (itemstack.tagCompound != null) {
			time.scheduleAtFixedRate(SkillFunctionTask(world, player, handIn), 0, 500)
		}
		return ActionResult(EnumActionResult.SUCCESS, itemstack)
	}

	override fun getItemUseAction(stack: ItemStack): EnumAction {
		return EnumAction.BLOCK
	}

	override fun getSubItems(tab: CreativeTabs, items: NonNullList<ItemStack>) {
		val nbt = NBTTagCompound()
		val stack = ItemStack(Core.skillbook, 1, 0, nbt)
		items.add(stack)
	}

	override fun onCreated(stack: ItemStack, worldIn: World, playerIn: EntityPlayer) {
		val nbt = NBTTagCompound()
		stack.tagCompound = nbt
	}
}