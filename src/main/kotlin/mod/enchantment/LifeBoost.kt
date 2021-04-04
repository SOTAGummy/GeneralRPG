package mod.enchantment

import com.google.common.collect.Multimap
import mod.item.baseitem.ItemAccessory
import net.minecraft.entity.SharedMonsterAttributes
import net.minecraft.entity.ai.attributes.AttributeModifier
import net.minecraft.item.ItemStack

object LifeBoost: AccessoryEnchantment("life_boost", Rarity.COMMON) {
	override fun getAttributes(stack: ItemStack, level: Int): Multimap<String, AttributeModifier> {
		val multimap = super.getAttributes(stack, level)
		val item = stack.item as ItemAccessory
		multimap.put(SharedMonsterAttributes.MAX_HEALTH.name, AttributeModifier(item.getUUID(item.equipmentSlot)!!, "hp", 2.0 * level, 0))
		return multimap
	}

	override fun getMaxLevel(): Int {
		return 5
	}

	override fun getMinLevel(): Int {
		return 1
	}
}