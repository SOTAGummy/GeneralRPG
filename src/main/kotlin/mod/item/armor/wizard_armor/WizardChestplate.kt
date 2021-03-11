package mod.item.armor.wizard_armor

import com.google.common.collect.Multimap
import mod.Core
import mod.enums.ItemRarity
import mod.item.baseitem.GeneralRPGArmor
import mod.util.ArmorType
import net.minecraft.entity.ai.attributes.AttributeModifier
import net.minecraft.inventory.EntityEquipmentSlot
import net.minecraft.item.ItemStack

object WizardChestplate :
	GeneralRPGArmor("wizard_chestplate", ArmorType.WizardArmor, EntityEquipmentSlot.CHEST, ItemRarity.RARE) {
	override fun getAttributeModifiers(
		slot: EntityEquipmentSlot,
		stack: ItemStack
	): Multimap<String, AttributeModifier> {
		val multimap = super.getAttributeModifiers(slot, stack)
		if (slot == EntityEquipmentSlot.CHEST) {
			multimap.put(Core.MAXMP.name, AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.index], "maxmp", 50.0, 0))
			multimap.put(
				Core.SAVINGRATE.name,
				AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.index], "savingrate", 5.0, 0)
			)
			multimap.put(
				Core.MPRECOVERRATE.name,
				AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.index], "reloadrate", 2.0, 0)
			)
		}
		return multimap
	}
}