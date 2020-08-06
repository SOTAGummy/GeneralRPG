package mod.capability.level

import net.minecraft.nbt.NBTBase
import net.minecraft.util.EnumFacing
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.CapabilityInject
import net.minecraftforge.common.capabilities.ICapabilitySerializable

class LevelProvider: ICapabilitySerializable<NBTBase> {
    companion object{
        @CapabilityInject(ILevel::class)
        val LEVEL_CAP: Capability<ILevel?>? = null
    }

    private val instance: ILevel? = LEVEL_CAP!!.defaultInstance

    override fun <T : Any?> getCapability(capability: Capability<T>, facing: EnumFacing?): T? {
        return if(capability === LEVEL_CAP) LEVEL_CAP.cast<T>(instance) else null
    }

    override fun hasCapability(capability: Capability<*>, facing: EnumFacing?): Boolean {
        return capability == LEVEL_CAP
    }

    override fun serializeNBT(): NBTBase? {
        return LEVEL_CAP!!.storage.writeNBT(LEVEL_CAP,instance,null)
    }

    override fun deserializeNBT(nbt: NBTBase?) {
        LEVEL_CAP!!.storage.readNBT(LEVEL_CAP,instance,null,nbt)
    }
}