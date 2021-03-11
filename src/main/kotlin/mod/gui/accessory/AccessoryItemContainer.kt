package mod.gui.accessory

import mod.Core
import mod.item.baseitem.ItemAccessory
import net.minecraft.item.ItemStack
import net.minecraftforge.items.ItemStackHandler

class AccessoryItemContainer : ItemStackHandler(4) {
	override fun isItemValid(slot: Int, stack: ItemStack): Boolean {
		return if (stack.item is ItemAccessory) {
			val equipmentSlot = (stack.item as ItemAccessory).equipmentSlot
			when (slot) {
				0 -> equipmentSlot == Core.necklace
				1 -> equipmentSlot == Core.amulet
				2 -> equipmentSlot == Core.glove
				3 -> equipmentSlot == Core.gem
				else -> false
			}
		} else false
	}

	override fun insertItem(slot: Int, stack: ItemStack, simulate: Boolean): ItemStack {
		if (!isItemValid(slot, stack)) return stack
		return super.insertItem(slot, stack, simulate)
	}

	override fun setStackInSlot(slot: Int, stack: ItemStack) {
		if (isItemValid(slot, stack)) {
			super.setStackInSlot(slot, stack)
		}
	}
}