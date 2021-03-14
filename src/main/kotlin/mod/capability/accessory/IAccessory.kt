package mod.capability.accessory

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack

interface IAccessory {
	fun getItem(slot: Int): ItemStack
	fun setItem(slot: Int, stack: ItemStack)
}