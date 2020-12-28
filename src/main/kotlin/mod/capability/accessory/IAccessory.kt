package mod.capability.accessory

import mod.item.baseitem.ItemAccessory
import net.minecraftforge.items.IItemHandlerModifiable

interface IAccessory: IItemHandlerModifiable{
	fun isValidItem(slot: Int, item: ItemAccessory): Boolean
}