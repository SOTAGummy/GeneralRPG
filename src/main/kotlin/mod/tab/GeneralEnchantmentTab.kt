package mod.tab

import mod.Core
import mod.util.Storage
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.init.Items
import net.minecraft.item.ItemStack
import net.minecraft.util.NonNullList

class GeneralEnchantmentTab: CreativeTabs("${Core.ID}.enchantment"){
	override fun getTabIconItem(): ItemStack {
		return ItemStack(Items.ENCHANTED_BOOK)
	}

	override fun displayAllRelevantItems(list: NonNullList<ItemStack>) {
		repeat(Storage.Enchantments.size){
			val stack = ItemStack(Items.ENCHANTED_BOOK)
			stack.addEnchantment(Storage.Enchantments[it], 5)
			list.add(stack)
		}
		super.displayAllRelevantItems(list)
	}
}