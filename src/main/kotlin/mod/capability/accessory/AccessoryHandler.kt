package mod.capability.accessory

import com.sun.org.apache.xpath.internal.operations.Bool
import mod.Core
import mod.item.baseitem.ItemAccessory
import net.minecraft.item.Item
import net.minecraft.item.ItemStack

class AccessoryHandler: IAccessory{
	override fun isValidItem(slot: Int, item: ItemAccessory): Boolean{
		return when(slot){
			0 -> item.equipmentSlot == Core.necklace
			1 -> item.equipmentSlot == Core.amulet
			2 -> item.equipmentSlot == Core.glove
			3 -> item.equipmentSlot == Core.gem
			else -> false
		}
	}

	override fun getSlotLimit(slot: Int): Int {
		return 4
	}

	override fun getSlots(): Int {
		return 4
	}

	override fun insertItem(slot: Int, stack: ItemStack, simulate: Boolean): ItemStack {
		if (stack.item is ItemAccessory && isValidItem(slot, stack.item as ItemAccessory))
			return
	}

	override fun extractItem(slot: Int, amount: Int, simulate: Boolean): ItemStack {
		TODO("Not yet implemented")
	}

	override fun getStackInSlot(slot: Int): ItemStack {
		TODO("Not yet implemented")
	}

	override fun setStackInSlot(slot: Int, stack: ItemStack) {
		TODO("Not yet implemented")
	}
}