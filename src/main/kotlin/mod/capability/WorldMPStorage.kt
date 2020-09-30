package mod.capability

import net.minecraft.nbt.NBTTagCompound
import net.minecraft.world.storage.WorldSavedData

class WorldMPStorage(name: String) : WorldSavedData(name) {
	override fun readFromNBT(nbt: NBTTagCompound) {

	}

	override fun writeToNBT(compound: NBTTagCompound): NBTTagCompound {
		return NBTTagCompound()
	}
}