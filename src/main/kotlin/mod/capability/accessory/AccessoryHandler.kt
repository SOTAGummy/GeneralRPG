package mod.capability.accessory

import mod.Core
import mod.item.baseitem.ItemAccessory
import net.minecraft.item.ItemStack
import net.minecraftforge.items.ItemStackHandler

class AccessoryHandler: ItemStackHandler(4), IAccessory{
	override fun isValidItem(slot: Int, stack: ItemStack): Boolean{
		if (stack.item is ItemAccessory){
			val item = stack.item as ItemAccessory
			return when(slot){
				0 -> item.equipmentSlot == Core.necklace
				1 -> item.equipmentSlot == Core.amulet
				2 -> item.equipmentSlot == Core.glove
				3 -> item.equipmentSlot == Core.gem
				else -> false
			}
		}
		return false
	}

	override fun getSlotLimit(slot: Int): Int {
		return 4
	}

	override fun getSlots(): Int {
		return 4
	}

	override fun insertItem(slot: Int, stack: ItemStack, simulate: Boolean): ItemStack {
		if (stack.item is ItemAccessory && !isValidItem(slot, stack))
			return stack
		return super.insertItem(slot, stack, simulate)
	}
}