package mod.tab

import mod.Core
import mod.Core.Companion.skillbook
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.ItemStack

class GeneralRPGTab : CreativeTabs(Core.ID) {
	override fun getTabIconItem(): ItemStack {
		return ItemStack(skillbook)
	}
}