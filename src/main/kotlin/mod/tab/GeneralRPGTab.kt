package mod.tab

import mod.Core
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.ItemStack

class GeneralRPGTab : CreativeTabs(Core.ID) {
	override fun getTabIconItem(): ItemStack {
		return ItemStack(Core.skill_book)
	}
}