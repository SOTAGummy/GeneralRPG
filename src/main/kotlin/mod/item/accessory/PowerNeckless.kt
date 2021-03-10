package mod.item.accessory

import com.google.common.collect.Multimap
import mod.Core
import mod.enchantment.AccessoryEnchantment
import mod.enums.ItemRarity
import mod.item.baseitem.ItemAccessory
import mod.util.Storage
import net.minecraft.enchantment.Enchantment
import net.minecraft.enchantment.EnchantmentHelper
import net.minecraft.entity.SharedMonsterAttributes
import net.minecraft.entity.ai.attributes.AttributeModifier
import net.minecraft.inventory.EntityEquipmentSlot
import net.minecraft.item.ItemStack
import java.util.*

object PowerNeckless: ItemAccessory("power_neckless", Core.necklace, ItemRarity.UNCOMMON){
	override fun getAttributeModifiers(slot: EntityEquipmentSlot, stack: ItemStack): Multimap<String, AttributeModifier> {
		val multimap = super.getAttributeModifiers(slot, stack)
		if (slot == Core.necklace){
			multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.name, AttributeModifier(UUID.fromString("426ba541-894a-459c-94e6-30dc2d92f582"), "atk", 2.0, 0))
		}
		return multimap
	}

	override fun canApplyAtEnchantingTable(stack: ItemStack, enchantment: Enchantment): Boolean {
		return true
	}
}