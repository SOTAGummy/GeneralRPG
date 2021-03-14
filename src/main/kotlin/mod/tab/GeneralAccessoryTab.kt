package mod.tab

import mod.Core
import mod.util.Storage
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.enchantment.EnumEnchantmentType
import net.minecraft.init.Items
import net.minecraft.item.ItemStack
import net.minecraft.util.NonNullList

class GeneralAccessoryTab : CreativeTabs("${Core.ID}.accessory") {
	override fun getTabIconItem(): ItemStack {
		return ItemStack(Items.DIAMOND_HELMET)
	}
}