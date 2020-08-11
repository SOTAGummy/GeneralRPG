package mod.block

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.Container
import net.minecraft.inventory.IInventory
import net.minecraft.inventory.Slot
import net.minecraft.item.ItemStack
import net.minecraft.util.EnumFacing
import net.minecraftforge.items.CapabilityItemHandler
import net.minecraftforge.items.IItemHandler
import net.minecraftforge.items.SlotItemHandler


class InjectionTableContainer(playerInv: IInventory, val te: TileEntityInjectionTable) : Container() {
	init {
		var inventory: IItemHandler? = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH)
		addSlotToContainer(SlotItemHandler(inventory, 1, 100, 100))
		addSlotToContainer(SlotItemHandler(inventory, 2, 140, 100))

		for (i in 0..2) {
			for (j in 0..8) {
				addSlotToContainer(Slot(playerInv, i * 9 + j, 8 + j * 18, 84 + i * 18))
			}
		}

		repeat(9) {
			addSlotToContainer(Slot(playerInv, it, 8 + it * 18, 142))
		}
	}

	override fun canInteractWith(playerIn: EntityPlayer): Boolean {
		return !playerIn.isSpectator
	}

	override fun transferStackInSlot(playerIn: EntityPlayer, index: Int): ItemStack {
		var itemstack: ItemStack = ItemStack.EMPTY
		var slot = inventorySlots[index]


		if (slot != null && slot.hasStack) {
			var itemstack1 = slot.stack
			itemstack = itemstack1.copy()
			val containerSlots: Int = inventorySlots.size - playerIn.inventory.mainInventory.size

			if (index < containerSlots) {
				if (!this.mergeItemStack(itemstack1, containerSlots, inventorySlots.size, true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.mergeItemStack(itemstack1, 0, containerSlots, false)) {
				return ItemStack.EMPTY;
			}

			if (itemstack1.count == 0) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}

			if (itemstack1.count == itemstack.count) {
				return ItemStack.EMPTY;
			}

			slot.onTake(playerIn, itemstack1);
		}
		return itemstack
	}
}