package mod.module

import mod.enums.ItemRarity
import net.minecraft.client.resources.I18n
import net.minecraft.util.text.TextComponentTranslation
import net.minecraft.util.text.TextFormatting

interface IGeneralRarity {
	val itemRarity: ItemRarity
	var originalName: String

	fun getGeneralRarity(): ItemRarity {
		return itemRarity
	}

	fun indicateRarity(tooltip: MutableList<String>, ){
		val rarityFormat = I18n.format(itemRarity.toString())
		val localizedRarity = TextComponentTranslation("text.rarity").formattedText
		tooltip.add("$localizedRarity : ${itemRarity.colorChar}${TextFormatting.BOLD}$rarityFormat")
	}

	fun indicateDisplayRarity(original: String): String {
		val star = TextComponentTranslation("text.star").formattedText
		val starFormat = I18n.format(star)
		val starColor = TextFormatting.YELLOW
		val starResult = "$starColor$starFormat".repeat(getGeneralRarity().ordinal + 1)

		val nameResult = "${getGeneralRarity().colorChar}${I18n.format(original)}"

		return "$nameResult  $starResult"
	}
}