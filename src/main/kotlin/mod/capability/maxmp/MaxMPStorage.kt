package mod.capability.maxmp

import net.minecraft.nbt.NBTBase
import net.minecraft.nbt.NBTPrimitive
import net.minecraft.nbt.NBTTagInt
import net.minecraft.util.EnumFacing
import net.minecraftforge.common.capabilities.Capability

class MaxMPStorage: Capability.IStorage<IMaxMP> {
	override fun readNBT(capability: Capability<IMaxMP>?, instance: IMaxMP?, side: EnumFacing?, nbt: NBTBase?) {
		instance!!.set((nbt as NBTPrimitive).int)
	}

	override fun writeNBT(capability: Capability<IMaxMP>?, instance: IMaxMP?, side: EnumFacing?): NBTBase? {
		return NBTTagInt(instance!!.get())
	}
}