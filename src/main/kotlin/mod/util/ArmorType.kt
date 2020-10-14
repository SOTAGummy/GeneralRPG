package mod.util

import mod.Core
import net.minecraft.init.SoundEvents
import net.minecraft.item.ItemArmor
import net.minecraft.util.SoundEvent
import net.minecraftforge.common.util.EnumHelper

class ArmorType {
	companion object {
		val StrongArmor = addArmorType("strong", "${Core.ID}:strong_armor", 5000, intArrayOf(3, 6, 8, 3), 15, SoundEvents.BLOCK_ANVIL_PLACE, 1.0F)
		val WizardArmor = addArmorType("wizard", "${Core.ID}:wizard_armor", 5000, intArrayOf(2, 2, 2, 2), 10, SoundEvents.BLOCK_CLOTH_PLACE, 0F)
		val ElectricArmor = addArmorType("electric", "${Core.ID}:electric_armor", 5000, intArrayOf(3, 6, 8, 3), 15, SoundEvents.BLOCK_ANVIL_PLACE, 1.0F)

		private fun addArmorType(name: String, texture: String, durability: Int, reduction: IntArray, enchantability: Int, sound: SoundEvent, toughness: Float): ItemArmor.ArmorMaterial? {
			return EnumHelper.addArmorMaterial(name, texture, durability, reduction, enchantability, sound, toughness)
		}
	}
}

