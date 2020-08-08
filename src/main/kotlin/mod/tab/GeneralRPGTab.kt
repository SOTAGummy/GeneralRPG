package mod.tab

import mod.Core
import mod.Core.Companion.heal
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.ItemStack

class GeneralRPGTab : CreativeTabs(Core.ID) {
	override fun getTabIconItem(): ItemStack {
		return ItemStack(heal)
	}
}