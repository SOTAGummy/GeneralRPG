package mod.util

import net.minecraft.client.resources.I18n
import net.minecraft.util.text.TextFormatting

fun String.paintBlack(): String{
	return "${TextFormatting.BLACK}${I18n.format(this)}"
}

fun String.paintDarkBlue(): String{
	return "${TextFormatting.DARK_BLUE}${I18n.format(this)}"
}

fun String.paintDarkGreen(): String{
	return "${TextFormatting.DARK_GREEN}${I18n.format(this)}"
}

fun String.paintDarkAqua(): String{
	return "${TextFormatting.DARK_AQUA}${I18n.format(this)}"
}

fun String.paintDarkRed(): String{
	return "${TextFormatting.DARK_RED}${I18n.format(this)}"
}

fun String.paintDarkPurple(): String{
	return "${TextFormatting.DARK_PURPLE}${I18n.format(this)}"
}

fun String.paintGold(): String{
	return "${TextFormatting.GOLD}${I18n.format(this)}"
}

fun String.paintGray(): String{
	return "${TextFormatting.GRAY}${I18n.format(this)}"
}

fun String.paintDarkGray(): String{
	return "${TextFormatting.DARK_GRAY}${I18n.format(this)}"
}

fun String.paintBlue(): String{
	return "${TextFormatting.BLUE}${I18n.format(this)}"
}

fun String.paintGreen(): String{
	return "${TextFormatting.GREEN}${I18n.format(this)}"
}

fun String.paintAqua(): String{
	return "${TextFormatting.AQUA}${I18n.format(this)}"
}

fun String.paintRed(): String{
	return "${TextFormatting.RED}${I18n.format(this)}"
}

fun String.paintPurple(): String{
	return "${TextFormatting.LIGHT_PURPLE}${I18n.format(this)}"
}

fun String.paintYellow(): String{
	return "${TextFormatting.YELLOW}${I18n.format(this)}"
}

fun String.paintWhite(): String{
	return "${TextFormatting.WHITE}${I18n.format(this)}"
}

fun String.paintObfuscated(): String{
	return "${TextFormatting.OBFUSCATED}${I18n.format(this)}"
}

fun String.paintBold(): String{
	return "${TextFormatting.BOLD}${I18n.format(this)}"
}

fun String.paintStrikethrough(): String{
	return "${TextFormatting.STRIKETHROUGH}${I18n.format(this)}"
}

fun String.paintUnderline(): String{
	return "${TextFormatting.UNDERLINE}${I18n.format(this)}"
}

fun String.paintItalic(): String{
	return "${TextFormatting.ITALIC}${I18n.format(this)}"
}

fun String.reset(): String{
	return "${TextFormatting.RESET}${I18n.format(this)}"
}