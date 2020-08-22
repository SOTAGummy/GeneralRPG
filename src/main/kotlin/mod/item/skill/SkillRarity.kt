package mod.item.skill

import net.minecraft.util.text.TextFormatting

enum class SkillRarity(val colorChar: TextFormatting) {
	COMMON(TextFormatting.WHITE),
	UNCOMMON(TextFormatting.GREEN),
	RARE(TextFormatting.AQUA),
	EPIC(TextFormatting.LIGHT_PURPLE),
	LEGEND(TextFormatting.GOLD),
	MASTER(TextFormatting.RED)
}