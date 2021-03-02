package mod.capability

import net.minecraft.nbt.NBTTagCompound
import net.minecraft.util.EnumFacing
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.CapabilityInject
import net.minecraftforge.common.capabilities.ICapabilitySerializable

class MpProvider: ICapabilitySerializable<NBTTagCompound>{
	companion object{
		@CapabilityInject(IMp::class)
		val MP: Capability<IMp>? = null
	}

	override fun serializeNBT(): NBTTagCompound {
		return MP?.storage?.writeNBT(MP, MP.defaultInstance, null) as NBTTagCompound
	}

	override fun deserializeNBT(nbt: NBTTagCompound?) {
		MP?.storage?.readNBT(MP, MP.defaultInstance, null, nbt)
	}

	override fun <T> getCapability(capability: Capability<T>, facing: EnumFacing?): T? {
		return if (capability === MP) MP.cast(MP.defaultInstance) else null
	}

	override fun hasCapability(capability: Capability<*>, facing: EnumFacing?): Boolean {
		return capability == MP
	}
}