package mod.capability.accessory

import net.minecraft.nbt.NBTBase
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.util.EnumFacing
import net.minecraftforge.common.capabilities.Capability

class AccessoryStorage: Capability.IStorage<IAccessory>{
	override fun readNBT(capability: Capability<IAccessory>?, instance: IAccessory?, side: EnumFacing?, nbt: NBTBase?) {
		val accessory = AccessoryItemContainer()
		accessory.deserializeNBT((nbt as NBTTagCompound).getTag("accessory") as NBTTagCompound?)

		instance?.insertItem(0, accessory.getStackInSlot(0), true)
		instance?.insertItem(1, accessory.getStackInSlot(1), true)
		instance?.insertItem(2, accessory.getStackInSlot(2), true)
		instance?.insertItem(3, accessory.getStackInSlot(3), true)
	}

	override fun writeNBT(capability: Capability<IAccessory>?, instance: IAccessory?, side: EnumFacing?): NBTBase {
		val necklace = instance?.getStackInSlot(0)
		val amulet = instance?.getStackInSlot(1)
		val glove = instance?.getStackInSlot(2)
		val gem = instance?.getStackInSlot(3)

		val accessory = AccessoryItemContainer()
		necklace?.let { accessory.setStackInSlot(0, it) }
		amulet?.let { accessory.setStackInSlot(1, it) }
		glove?.let { accessory.setStackInSlot(2, it) }
		gem?.let { accessory.setStackInSlot(3, it) }

		val nbt = NBTTagCompound()
		nbt.setTag("accessory", accessory.serializeNBT())

		return nbt
	}
}