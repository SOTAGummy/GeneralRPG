package mod.capability.exp

import net.minecraft.nbt.NBTBase
import net.minecraft.util.EnumFacing
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.CapabilityInject
import net.minecraftforge.common.capabilities.ICapabilitySerializable

class ExpProvider: ICapabilitySerializable<NBTBase> {
    companion object{
        @CapabilityInject(IExp::class)
        val EXP_CAP:Capability<IExp?>? = null
    }

    private val instance: IExp? = EXP_CAP?.defaultInstance

    override fun <T : Any?> getCapability(capability: Capability<T>, facing: EnumFacing?): T? {
        return if(capability === EXP_CAP) EXP_CAP.cast<T>(instance) else null
    }

    override fun hasCapability(capability: Capability<*>, facing: EnumFacing?): Boolean {
        return capability == EXP_CAP
    }

    override fun serializeNBT(): NBTBase? {
        return EXP_CAP!!.storage.writeNBT(EXP_CAP,instance,null)
    }

    override fun deserializeNBT(nbt: NBTBase?) {
        EXP_CAP!!.storage.readNBT(EXP_CAP,instance,null,nbt)
    }
}