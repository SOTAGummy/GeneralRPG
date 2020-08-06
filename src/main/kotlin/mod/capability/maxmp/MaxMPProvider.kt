package mod.capability.maxmp

import net.minecraft.nbt.NBTBase
import net.minecraft.util.EnumFacing
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.CapabilityInject
import net.minecraftforge.common.capabilities.ICapabilitySerializable

class MaxMPProvider: ICapabilitySerializable<NBTBase> {
	companion object{
		@CapabilityInject(IMaxMP::class)
		val MAX_MP_CAP: Capability<IMaxMP?>? = null
	}

	private val instance: IMaxMP? = MAX_MP_CAP?.defaultInstance

	override fun <T : Any?> getCapability(capability: Capability<T>, facing: EnumFacing?): T? {
		return if(capability === MAX_MP_CAP) MAX_MP_CAP.cast<T>(instance) else null
	}

	override fun hasCapability(capability: Capability<*>, facing: EnumFacing?): Boolean {
		return capability == MAX_MP_CAP
	}

	override fun serializeNBT(): NBTBase? {
		return MAX_MP_CAP!!.storage.writeNBT(MAX_MP_CAP,instance,null)
	}

	override fun deserializeNBT(nbt: NBTBase?) {
		MAX_MP_CAP!!.storage.readNBT(MAX_MP_CAP,instance,null,nbt)
	}
}