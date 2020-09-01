package mod.item.skill

import mod.item.baseitem.ItemSkill
import net.minecraft.util.text.TextFormatting

enum class SkillRarity(val colorChar: TextFormatting, val skills: ArrayList<ItemSkill>) {
	COMMON(TextFormatting.WHITE, arrayListOf()),
	UNCOMMON(TextFormatting.GREEN, arrayListOf()),
	RARE(TextFormatting.AQUA, arrayListOf()),
	EPIC(TextFormatting.LIGHT_PURPLE, arrayListOf()),
	LEGEND(TextFormatting.GOLD, arrayListOf()),
	MYTHIC(TextFormatting.YELLOW, arrayListOf()),
	EXTRA(TextFormatting.DARK_BLUE, arrayListOf()),
	MASTER(TextFormatting.RED, arrayListOf())
}