package mod.tab

import mod.Core
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.init.Items
import net.minecraft.item.ItemStack

class GeneralAccessoryTab : CreativeTabs("${Core.ID}.accessory") {
	override fun getTabIconItem(): ItemStack {
		return ItemStack(Items.DIAMOND_HELMET)
	}
}