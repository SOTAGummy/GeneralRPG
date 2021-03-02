package mod.block

import net.minecraft.entity.item.EntityItem
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.tileentity.TileEntity
import net.minecraftforge.items.ItemStackHandler


class TileEntityInjectionTable : TileEntity() {
	private val inventory: ItemStackHandler = ItemStackHandler(1)
	private var item: EntityItem? = null

	fun getStack(): ItemStack {
		return inventory.getStackInSlot(0)
	}

	fun setStack(stack: ItemStack) {
		inventory.setStackInSlot(0, stack)
	}

	fun getEntity(): EntityItem? {
		return item
	}

	fun setEntity(entityItem: EntityItem?) {
		item = entityItem
	}

	override fun writeToNBT(compound: NBTTagCompound): NBTTagCompound {
		compound.merge(inventory.serializeNBT())
		item?.serializeNBT().let { compound.merge(item?.serializeNBT()) }
		return compound
	}

	override fun readFromNBT(compound: NBTTagCompound) {
		inventory.deserializeNBT(compound)
		item?.deserializeNBT(compound)
	}
}