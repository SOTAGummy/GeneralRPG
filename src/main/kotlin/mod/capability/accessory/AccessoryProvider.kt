package mod.capability.accessory

import net.minecraft.nbt.NBTBase
import net.minecraft.util.EnumFacing
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.CapabilityInject
import net.minecraftforge.common.capabilities.ICapabilitySerializable
import net.minecraftforge.items.CapabilityItemHandler

class AccessoryProvider: ICapabilitySerializable<NBTBase>{
	@CapabilityInject(IAccessory::class)
	lateinit var accessoryCap: Capability<IAccessory>
	private val instance = accessoryCap.defaultInstance

	override fun deserializeNBT(nbt: NBTBase?) {
		accessoryCap.storage.readNBT(accessoryCap, instance, null, nbt)
	}

	override fun serializeNBT(): NBTBase {
		return accessoryCap.storage.writeNBT(accessoryCap, instance, null)!!
	}

	override fun <T : Any?> getCapability(capability: Capability<T>, facing: EnumFacing?): T? {
		return if (capability == accessoryCap) accessoryCap.cast(instance)
			else null
	}

	override fun hasCapability(capability: Capability<*>, facing: EnumFacing?): Boolean {
		return capability == accessoryCap
	}
}