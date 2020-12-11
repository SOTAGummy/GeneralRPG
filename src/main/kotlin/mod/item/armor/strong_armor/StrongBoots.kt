package mod.item.armor.strong_armor

import com.google.common.collect.Multimap
import mod.enums.ItemRarity
import mod.item.baseitem.GeneralRPGArmor
import mod.util.ArmorType
import mod.util.Attributes
import net.minecraft.entity.SharedMonsterAttributes
import net.minecraft.entity.ai.attributes.AttributeModifier
import net.minecraft.inventory.EntityEquipmentSlot
import net.minecraft.item.ItemStack

object StrongBoots : GeneralRPGArmor("strong_boots", ArmorType.StrongArmor, EntityEquipmentSlot.FEET, ItemRarity.RARE) {
	override fun getAttributeModifiers(
		slot: EntityEquipmentSlot,
		stack: ItemStack
	): Multimap<String, AttributeModifier> {
		val multimap = super.getAttributeModifiers(slot, stack)
		if (slot == EntityEquipmentSlot.FEET) {
			multimap.put(
				SharedMonsterAttributes.ATTACK_DAMAGE.name,
				AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.index], "strength", 2.0, 0)
			)
			multimap.put(
				Attributes.MAXMP.name,
				AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.index], "health", 50.0, 0)
			)
		}
		return multimap
	}
}