package mod.capability.accessory

import mod.item.baseitem.ItemAccessory
import net.minecraft.item.ItemStack
import net.minecraftforge.items.IItemHandlerModifiable

interface IAccessory: IItemHandlerModifiable{
	fun isValidItem(slot: Int, stack: ItemStack): Boolean
}