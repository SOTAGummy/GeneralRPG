package mod.item.baseitem

import mod.Core
import mod.enums.ItemRarity
import mod.util.JsonReference
import net.minecraft.client.resources.I18n
import net.minecraft.client.util.ITooltipFlag
import net.minecraft.entity.ai.attributes.AttributeModifier
import net.minecraft.inventory.EntityEquipmentSlot
import net.minecraft.item.ItemStack
import net.minecraft.util.ResourceLocation
import net.minecraft.util.text.TextComponentTranslation
import net.minecraft.util.text.TextFormatting
import net.minecraft.world.World
import java.io.File

open class ItemAccessory(name: String, slot: EntityEquipmentSlot, rarity: ItemRarity): GeneralRPGItem(rarity){
	val equipmentSlot = slot

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

	fun getSlot(): EntityEquipmentSlot{
		return  equipmentSlot
	}
}