package mod.capability.level

import net.minecraft.nbt.NBTBase
import net.minecraft.nbt.NBTPrimitive
import net.minecraft.nbt.NBTTagInt
import net.minecraft.util.EnumFacing
import net.minecraftforge.common.capabilities.Capability

class LevelStorage: Capability.IStorage<ILevel>{
    override fun readNBT(capability: Capability<ILevel>?, instance: ILevel?, side: EnumFacing?, nbt: NBTBase?) {
        instance!!.set((nbt as NBTPrimitive).int)
    }


    override fun writeNBT(capability: Capability<ILevel>?, instance: ILevel?, side: EnumFacing?): NBTBase? {
        return NBTTagInt(instance!!.get())
    }
}