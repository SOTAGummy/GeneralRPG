package mod.capability

import net.minecraftforge.common.capabilities.ICapabilitySerializable
import net.minecraft.nbt.NBTBase
import mod.capability.IMp
import mod.capability.MpProvider
import net.minecraft.util.EnumFacing
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.CapabilityInject

class MpProvider : ICapabilitySerializable<NBTBase?> {
	private val instance = MP!!.defaultInstance
	override fun hasCapability(capability: Capability<*>, facing: EnumFacing?): Boolean {
		return capability === MP
	}

	override fun <T> getCapability(capability: Capability<T>, facing: EnumFacing?): T? {
		return if (capability === MP) MP.cast(instance) else null
	}

	override fun serializeNBT(): NBTBase? {
		return MP!!.storage.writeNBT(MP, instance, null)
	}

	override fun deserializeNBT(nbt: NBTBase?) {
		MP!!.storage.readNBT(MP, instance, null, nbt)
	}

	companion object {
		@CapabilityInject(IMp::class)
		val MP: Capability<IMp?>? = null
	}
}