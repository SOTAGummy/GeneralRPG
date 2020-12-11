package mod.item.armor.strong_armor

import com.google.common.collect.Multimap
import mod.enums.ItemRarity
import mod.item.baseitem.GeneralRPGArmor
import mod.util.ArmorType
import net.minecraft.entity.SharedMonsterAttributes
import net.minecraft.entity.ai.attributes.AttributeModifier
import net.minecraft.inventory.EntityEquipmentSlot
import net.minecraft.item.ItemStack

object StrongHelmet :
	GeneralRPGArmor("strong_helmet", ArmorType.StrongArmor, EntityEquipmentSlot.HEAD, ItemRarity.RARE) {
	override fun getAttributeModifiers(
		slot: EntityEquipmentSlot,
		stack: ItemStack
	): Multimap<String, AttributeModifier> {
		val multimap = super.getAttributeModifiers(slot, stack)
		if (slot == EntityEquipmentSlot.HEAD) {
			multimap.put(
				SharedMonsterAttributes.ATTACK_DAMAGE.name,
				AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.index], "strength", 2.0, 0)
			)
			multimap.put(
				SharedMonsterAttributes.MAX_HEALTH.name,
				AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.index], "health", 10.0, 0)
			)
		}
		return multimap
	}
}