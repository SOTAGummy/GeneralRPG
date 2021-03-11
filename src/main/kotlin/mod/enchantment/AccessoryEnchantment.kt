package mod.enchantment

import com.google.common.collect.HashMultimap
import com.google.common.collect.Multimap
import mod.Core
import mod.item.baseitem.ItemAccessory
import mod.util.Storage
import net.minecraft.enchantment.Enchantment
import net.minecraft.entity.ai.attributes.AttributeModifier
import net.minecraft.item.ItemStack
import net.minecraft.util.ResourceLocation

open class AccessoryEnchantment(name: String, rarity: Rarity) :
	Enchantment(rarity, Core.accessoryType, arrayOf(Core.necklace, Core.amulet, Core.glove, Core.gem)) {
	init {
		Storage.Enchantments.add(this)
		this.registryName = ResourceLocation(Core.ID, name)
		this.name = name
	}

	open fun getAttributes(stack: ItemStack, level: Int): Multimap<String, AttributeModifier> {
		return HashMultimap.create()
	}

	override fun canApply(stack: ItemStack): Boolean {
		return stack.item is ItemAccessory
	}

	override fun canApplyAtEnchantingTable(stack: ItemStack): Boolean {
		return stack.item is ItemAccessory
	}

	override fun getMinLevel(): Int {
		return 1
	}

	override fun isTreasureEnchantment(): Boolean {
		return true
	}
}