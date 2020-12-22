package mod.item.baseitem

import mod.Core
import mod.enums.ItemRarity
import mod.util.JsonReference
import net.minecraft.client.resources.I18n
import net.minecraft.client.util.ITooltipFlag
import net.minecraft.entity.ai.attributes.AttributeModifier
import net.minecraft.item.ItemStack
import net.minecraft.util.ResourceLocation
import net.minecraft.util.text.TextComponentTranslation
import net.minecraft.util.text.TextFormatting
import net.minecraft.world.World
import java.io.File

open class ItemAccessory(name: String, rarity: ItemRarity): GeneralRPGItem(rarity){
	val attributeMap: ArrayList<AttributeModifier> = arrayListOf()

	init {
		this.creativeTab = Core.accessoryTab
		this.registryName = ResourceLocation(Core.ID, name)
		this.unlocalizedName = name
		this.maxStackSize = 1

		val file = File("D:\\mod\\GeneralRPG\\src\\main\\resources\\assets\\general-rpg\\models\\item\\$name.json")
		if (!file.exists()) {
			file.createNewFile()
			file.writeText(JsonReference.getJsonText(name))
		}
	}

	override fun addInformation(stack: ItemStack, worldIn: World?, tooltip: MutableList<String>, flagIn: ITooltipFlag) {
		attributeMap[0].let {
			tooltip.add(TextComponentTranslation("text.equipping").formattedText)
		}
		repeat(attributeMap.size){
			if (attributeMap[it].operation == 0){
				if (attributeMap[it].amount > 0)
					tooltip.add(" ${TextFormatting.BLUE}${I18n.format(TextComponentTranslation(attributeMap[it].name).formattedText)} ${TextFormatting.BLUE}${I18n.format("+${attributeMap[it].amount}")}")
				else
					tooltip.add(" ${TextFormatting.RED}${I18n.format(TextComponentTranslation(attributeMap[it].name).formattedText)} ${TextFormatting.RED}${I18n.format("-${attributeMap[it].amount}")}")
			}else{
				if (attributeMap[it].amount > 0)
					tooltip.add(" ${TextFormatting.BLUE}${I18n.format(TextComponentTranslation(attributeMap[it].name).formattedText)} ${TextFormatting.BLUE}${I18n.format("${attributeMap[it].amount}%")}")
				else
					tooltip.add(" ${TextFormatting.RED}${I18n.format(TextComponentTranslation(attributeMap[it].name).formattedText)} ${TextFormatting.RED}${I18n.format("${attributeMap[it].amount}%")}")
			}
		}
		super.addInformation(stack, worldIn, tooltip, flagIn)
	}
}