package mod.item.baseitem

import com.google.common.collect.Multimap
import mod.Core
import mod.enums.ItemRarity
import mod.util.Reference
import mod.util.Storage
import net.minecraft.enchantment.EnchantmentHelper
import net.minecraft.entity.ai.attributes.AttributeModifier
import net.minecraft.inventory.EntityEquipmentSlot
import net.minecraft.item.ItemStack
import net.minecraft.util.ResourceLocation
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
			file.writeText(Reference.getJsonText(name))
		}
	}

	fun getSlot(): EntityEquipmentSlot{
		return  equipmentSlot
	}

	override fun getAttributeModifiers(slot: EntityEquipmentSlot, stack: ItemStack): Multimap<String, AttributeModifier> {
		val multimap = super.getAttributeModifiers(slot, stack)

		if (stack.isItemEnchanted) {
			repeat(Storage.Enchantments.size){
				val level = EnchantmentHelper.getEnchantmentLevel(Storage.Enchantments[it], stack)
				if (level > 0){
					val enchantment = Storage.Enchantments[it]
					multimap.putAll(enchantment.getAttributes())
				}
			}
		}
		return super.getAttributeModifiers(slot, stack)
	}
}