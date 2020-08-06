package mod.capability.exp

import net.minecraft.nbt.NBTBase
import net.minecraft.nbt.NBTPrimitive
import net.minecraft.nbt.NBTTagInt
import net.minecraft.util.EnumFacing
import net.minecraftforge.common.capabilities.Capability

class ExpStorage: Capability.IStorage<IExp> {
    override fun readNBT(capability: Capability<IExp>?, instance: IExp?, side: EnumFacing?, nbt: NBTBase?) {
        instance!!.set((nbt as NBTPrimitive).int)
    }

    override fun writeNBT(capability: Capability<IExp>?, instance: IExp?, side: EnumFacing?): NBTBase? {
        return NBTTagInt(instance!!.get())
    }
}