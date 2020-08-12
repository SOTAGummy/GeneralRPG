package mod.item.items

import mod.Core
import mod.item.baseitem.GeneralRPGItem
import net.minecraft.client.util.ITooltipFlag
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.ResourceLocation
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
		if (stack.tagCompound != null && stack.tagCompound!!.getString("1") != null) {
			tooltip.add(ItemStack(Item.getByNameOrId(stack.tagCompound!!.getString("1"))).displayName)
		}
	}
}