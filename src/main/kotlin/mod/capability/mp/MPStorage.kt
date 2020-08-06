package mod.capability.mp

import net.minecraft.nbt.NBTBase
import net.minecraft.nbt.NBTPrimitive
import net.minecraft.nbt.NBTTagInt
import net.minecraft.util.EnumFacing
import net.minecraftforge.common.capabilities.Capability

class MPStorage: Capability.IStorage<IMP> {
    override fun readNBT(capability: Capability<IMP>?, instance: IMP?, side: EnumFacing?, nbt: NBTBase?) {
        instance!!.set((nbt as NBTPrimitive).int)
    }

    override fun writeNBT(capability: Capability<IMP>?, instance: IMP?, side: EnumFacing?): NBTBase? {
        return NBTTagInt(instance!!.get())
    }
}