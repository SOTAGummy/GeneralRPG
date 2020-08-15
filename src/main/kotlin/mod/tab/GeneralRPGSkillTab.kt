package mod.tab

import mod.Core
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.ItemStack

class GeneralRPGSkillTab : CreativeTabs(Core.ID + ".skill") {
	override fun getTabIconItem(): ItemStack {
		return ItemStack(Core.heal)
	}
}