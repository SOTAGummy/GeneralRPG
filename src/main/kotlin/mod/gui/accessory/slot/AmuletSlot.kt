package mod.gui.accessory.slot

import mod.Core
import mod.item.baseitem.ItemAccessory
import mod.util.Attributes
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraftforge.items.IItemHandler
import net.minecraftforge.items.SlotItemHandler

class AmuletSlot(inventory: IItemHandler, index: Int, x: Int, y: Int): SlotItemHandler(inventory, index, x, y){
	override fun isItemValid(stack: ItemStack): Boolean {
		return stack.item is ItemAccessory && (stack.item as ItemAccessory).equipmentSlot == Core.amulet
	}
}