package mod.item

import mod.Core
import mod.enums.ItemRarity
import mod.item.baseitem.GeneralRPGItem
import mod.module.IGeneralRarity
import net.minecraft.client.util.ITooltipFlag
import net.minecraft.item.ItemStack
import net.minecraft.util.ResourceLocation
import net.minecraft.world.World

object SkillDust: GeneralRPGItem(ItemRarity.COMMON), IGeneralRarity{
	init {
		this.maxStackSize = 64
		this.unlocalizedName = "skill_dust"
		this.registryName = ResourceLocation(Core.ID, "skill_dust")
	}

	override val itemRarity: ItemRarity = ItemRarity.COMMON

	override fun addInformation(stack: ItemStack, worldIn: World?, tooltip: MutableList<String>, flagIn: ITooltipFlag) {
		indicateRarity(tooltip)
	}
}