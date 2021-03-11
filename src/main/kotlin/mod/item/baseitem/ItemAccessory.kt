package mod.item.baseitem

import com.google.common.collect.Multimap
import mod.Core
import mod.enchantment.AccessoryEnchantment
import mod.enums.ItemRarity
import mod.util.Reference
import mod.util.Storage
import net.minecraft.enchantment.Enchantment
import net.minecraft.enchantment.EnchantmentHelper
import net.minecraft.entity.ai.attributes.AttributeModifier
import net.minecraft.inventory.EntityEquipmentSlot
import net.minecraft.item.ItemStack
import net.minecraft.util.ResourceLocation
import java.io.File
import java.util.*

open class ItemAccessory(name: String, val equipmentSlot: EntityEquipmentSlot, rarity: ItemRarity) :
	GeneralRPGItem(rarity) {
	companion object {
		val ACCESSORY_MODIFIER = arrayListOf(
			UUID.fromString("1ee3ca10-3da2-4d4a-b15c-b4c62dca1f8f"),
			UUID.fromString("a139bb38-cd04-481a-b4b8-f55da85be43b"),
			UUID.fromString("ca10532a-fdf9-4292-b7ba-5ef20e252946"),
			UUID.fromString("e28a417d-5e63-4b9e-918f-1df81a6ac257")
		)
	}

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

	override fun getAttributeModifiers(
		slot: EntityEquipmentSlot,
		stack: ItemStack
	): Multimap<String, AttributeModifier> {
		val multimap = super.getAttributeModifiers(slot, stack)

		if (slot == (stack.item as ItemAccessory).equipmentSlot) {
			if (stack.isItemEnchanted) {
				repeat(Storage.Enchantments.size) {
					val enchantment = Storage.Enchantments[it]
					val level = EnchantmentHelper.getEnchantmentLevel(Storage.Enchantments[it], stack)
					if (level > 0) {
						if (!enchantment.getAttributes(stack, level).isEmpty) {
							multimap.putAll(Storage.Enchantments[it].getAttributes(stack, level))
						}
					}
				}
			}
		}
		return multimap
	}

	fun getUUID(slot: EntityEquipmentSlot): UUID? {
		return if (slot.index - 4 > 0) ACCESSORY_MODIFIER[slot.index - 4] else null
	}

	override fun isEnchantable(stack: ItemStack): Boolean {
		return true
	}

	override fun canApplyAtEnchantingTable(stack: ItemStack, enchantment: Enchantment): Boolean {
		return enchantment is AccessoryEnchantment
	}

	override fun isRepairable(): Boolean {
		return true
	}

	override fun isDamageable(): Boolean {
		return true
	}
}