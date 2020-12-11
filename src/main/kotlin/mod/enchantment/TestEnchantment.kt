package mod.enchantment

import net.minecraft.enchantment.Enchantment
import net.minecraft.enchantment.EnumEnchantmentType
import net.minecraft.inventory.EntityEquipmentSlot

class TestEnchantment :
	Enchantment(Enchantment.Rarity.RARE, EnumEnchantmentType.WEAPON, arrayOf(EntityEquipmentSlot.MAINHAND)) {

}