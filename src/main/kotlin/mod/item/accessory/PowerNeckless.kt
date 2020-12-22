package mod.item.accessory

import com.google.common.collect.Multimap
import mod.enums.ItemRarity
import mod.item.baseitem.ItemAccessory
import net.minecraft.entity.ai.attributes.AttributeModifier
import net.minecraft.inventory.EntityEquipmentSlot
import net.minecraft.item.ItemStack
import java.util.*

object PowerNeckless: ItemAccessory("power_neckless", ItemRarity.UNCOMMON){
	init {
		attributeMap.add(AttributeModifier(UUID.fromString("48500c3d-6c7f-47e9-88a1-18b33302601f"), "generic.maxHealth", 10.0, 0))
	}

	override fun getAttributeModifiers(slot: EntityEquipmentSlot, stack: ItemStack): Multimap<String, AttributeModifier> {
		return super.getAttributeModifiers(slot, stack)
	}
}