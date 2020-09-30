package mod.enums

import mod.item.baseitem.ItemSkill
import net.minecraft.util.text.TextFormatting

enum class SkillRarity(val colorChar: TextFormatting, val skills: ArrayList<ItemSkill>, val colorCode: Int) {
	COMMON(TextFormatting.WHITE, arrayListOf(), 16777215),
	UNCOMMON(TextFormatting.GREEN, arrayListOf(), 5635925),
	RARE(TextFormatting.AQUA, arrayListOf(), 5636095),
	EPIC(TextFormatting.LIGHT_PURPLE, arrayListOf(), 16733695),
	LEGEND(TextFormatting.GOLD, arrayListOf(), 16755200),
	MYTHIC(TextFormatting.YELLOW, arrayListOf(), 16777045),
	EXTRA(TextFormatting.DARK_BLUE, arrayListOf(), 170),
	MASTER(TextFormatting.RED, arrayListOf(), 16733525)
}