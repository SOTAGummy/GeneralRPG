package mod.item.armor.electric_armor

import com.google.common.collect.Multimap
import mod.enums.ItemRarity
import mod.item.baseitem.GeneralRPGArmor
import mod.util.ArmorType
import mod.util.Attributes
import net.minecraft.entity.SharedMonsterAttributes
import net.minecraft.entity.ai.attributes.AttributeModifier
import net.minecraft.inventory.EntityEquipmentSlot
import net.minecraft.item.ItemStack

object ElectricHelmet: GeneralRPGArmor("electric_helmet", ArmorType.ElectricArmor, EntityEquipmentSlot.HEAD, ItemRarity.EPIC){
	override fun getAttributeModifiers(slot: EntityEquipmentSlot, stack: ItemStack): Multimap<String, AttributeModifier> {
		val multimap = super.getAttributeModifiers(slot, stack)
		if (slot == EntityEquipmentSlot.FEET) {
			multimap.put(Attributes.ELECTRICATTACK.name, AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.index], "electricattack", 1.0, 0))
			multimap.put(SharedMonsterAttributes.MAX_HEALTH.name, AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.index], "maxhealth", 2.5, 0))
		}
		return multimap
	}
}