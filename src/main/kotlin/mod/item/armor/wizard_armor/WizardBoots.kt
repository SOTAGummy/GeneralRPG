package mod.item.armor.wizard_armor

import com.google.common.collect.Multimap
import mod.enums.SkillRarity
import mod.item.baseitem.GeneralRPGArmor
import mod.util.ArmorType
import mod.util.Attributes
import net.minecraft.entity.ai.attributes.AttributeModifier
import net.minecraft.inventory.EntityEquipmentSlot
import net.minecraft.item.ItemStack

object WizardBoots : GeneralRPGArmor("wizard_boots", ArmorType.WizardArmor, EntityEquipmentSlot.FEET, SkillRarity.RARE) {
	override fun getAttributeModifiers(slot: EntityEquipmentSlot, stack: ItemStack): Multimap<String, AttributeModifier> {
		val multimap = super.getAttributeModifiers(slot, stack)
		if (slot == EntityEquipmentSlot.FEET) {
			multimap.put(Attributes.MAXMP.name, AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.index], "maxmp", 50.0, 0))
			multimap.put(Attributes.DEXTERITY.name, AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.index], "dexterity", 5.0, 0))
			multimap.put(Attributes.MPRECOVERRATE.name, AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.index], "reloadrate", 2.0, 0))
		}
		return multimap
	}
}