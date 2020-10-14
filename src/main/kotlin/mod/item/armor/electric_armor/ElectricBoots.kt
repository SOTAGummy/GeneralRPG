package mod.item.armor.electric_armor

import com.google.common.collect.Multimap
import mod.enums.ItemRarity
import mod.item.baseitem.GeneralRPGArmor
import mod.util.ArmorType
import net.minecraft.entity.SharedMonsterAttributes
import net.minecraft.entity.ai.attributes.AttributeModifier
import net.minecraft.inventory.EntityEquipmentSlot
import net.minecraft.item.ItemStack

object ElectricBoots: GeneralRPGArmor("electric_boots", ArmorType.ElectricArmor, EntityEquipmentSlot.FEET, ItemRarity.EPIC){
	override fun getAttributeModifiers(slot: EntityEquipmentSlot, stack: ItemStack): Multimap<String, AttributeModifier> {
		val multimap = super.getAttributeModifiers(slot, stack)
		if (slot == EntityEquipmentSlot.FEET) {
			multimap.put(SharedMonsterAttributes.MOVEMENT_SPEED.name, AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.index], "move", 0.05, 0))
			multimap.put(SharedMonsterAttributes.MAX_HEALTH.name, AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.index], "maxhealth", 2.5, 0))
		}
		return multimap
	}
}