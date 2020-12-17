package mod.module

import mod.enums.ItemRarity
import net.minecraft.client.resources.I18n
import net.minecraft.util.text.TextComponentTranslation
import net.minecraft.util.text.TextFormatting

interface IGeneralRarity {
	val itemRarity: ItemRarity

	fun getGeneralRarity(): ItemRarity {
		return itemRarity
	}

	fun indicateRarity(tooltip: MutableList<String>) {
		val rarityFormat = I18n.format(itemRarity.toString())
		val localizedRarity = TextComponentTranslation("text.rarity").formattedText
		tooltip.add("$localizedRarity : ${itemRarity.colorChar}${TextFormatting.BOLD}$rarityFormat")
	}
}