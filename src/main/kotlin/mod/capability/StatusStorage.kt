package mod.capability

import net.minecraft.nbt.NBTBase
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.util.EnumFacing
import net.minecraftforge.common.capabilities.Capability

class StatusStorage : Capability.IStorage<IStatus> {
	override fun readNBT(capability: Capability<IStatus>?, instance: IStatus?, side: EnumFacing?, nbt: NBTBase?) {
		instance!!.setExp((nbt as NBTTagCompound).getInteger("exp"))
		instance.setLevel(nbt.getInteger("level"))
		instance.setMp(nbt.getInteger("mp"))
		instance.setMaxMp(nbt.getInteger("maxmp"))
	}

	override fun writeNBT(capability: Capability<IStatus>?, instance: IStatus?, side: EnumFacing?): NBTBase? {
		val nbt = NBTTagCompound()
		nbt.setInteger("exp", instance!!.getExp())
		nbt.setInteger("level", instance.getLevel())
		nbt.setInteger("mp", instance.getMp())
		nbt.setInteger("maxmp", instance.getMaxMp())
		return nbt
	}
}