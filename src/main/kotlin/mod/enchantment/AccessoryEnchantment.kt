package mod.enchantment

import com.google.common.collect.HashMultimap
import com.google.common.collect.Multimap
import mod.Core
import mod.util.Storage
import net.minecraft.enchantment.Enchantment
import net.minecraft.entity.ai.attributes.AttributeModifier

open class AccessoryEnchantment(rarity: Rarity): Enchantment(rarity, Core.accessoryType, arrayOf(Core.necklace, Core.amulet, Core.glove, Core.gem)){
	init {
		Storage.Enchantments.add(this)
	}

	fun getAttributes(): Multimap<String, AttributeModifier>?{
		return HashMultimap.create()
	}
}