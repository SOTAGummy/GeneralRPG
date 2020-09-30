package mod.capability

import net.minecraft.nbt.NBTBase
import net.minecraft.util.EnumFacing
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.CapabilityInject
import net.minecraftforge.common.capabilities.ICapabilitySerializable

class StatusProvider : ICapabilitySerializable<NBTBase> {
	companion object {
		@CapabilityInject(IStatus::class)
		val STATUS_CAP: Capability<IStatus>? = null
	}

	private val instance: IStatus? = STATUS_CAP?.defaultInstance

	override fun <T : Any?> getCapability(capability: Capability<T>, facing: EnumFacing?): T? {
		return if (capability === STATUS_CAP) STATUS_CAP.cast<T>(instance) else null
	}

	override fun hasCapability(capability: Capability<*>, facing: EnumFacing?): Boolean {
		return capability == STATUS_CAP
	}

	override fun serializeNBT(): NBTBase? {
		return STATUS_CAP!!.storage.writeNBT(STATUS_CAP, instance, null)
	}

	override fun deserializeNBT(nbt: NBTBase?) {
		STATUS_CAP!!.storage.readNBT(STATUS_CAP, instance, null, nbt)
	}
}