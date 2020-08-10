package mod.capability.mp

import net.minecraft.nbt.NBTBase
import net.minecraft.util.EnumFacing
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.CapabilityInject
import net.minecraftforge.common.capabilities.ICapabilitySerializable

class MPProvider : ICapabilitySerializable<NBTBase> {
	companion object {
		@CapabilityInject(IMP::class)
		val MP_CAP: Capability<IMP?>? = null
	}

	private val instance: IMP? = MP_CAP?.defaultInstance

	override fun <T : Any?> getCapability(capability: Capability<T>, facing: EnumFacing?): T? {
		return if (capability === MP_CAP) MP_CAP.cast<T>(instance) else null
	}

	override fun hasCapability(capability: Capability<*>, facing: EnumFacing?): Boolean {
		return capability == MP_CAP
	}

	override fun serializeNBT(): NBTBase? {
		return MP_CAP!!.storage.writeNBT(MP_CAP, instance, null)
	}

	override fun deserializeNBT(nbt: NBTBase?) {
		MP_CAP!!.storage.readNBT(MP_CAP, instance, null, nbt)
	}
}
