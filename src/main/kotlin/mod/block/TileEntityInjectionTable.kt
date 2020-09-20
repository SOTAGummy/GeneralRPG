package mod.block

import net.minecraft.nbt.NBTTagCompound
import net.minecraft.tileentity.TileEntity
import java.util.*


class TileEntityInjectionTable : TileEntity() {
	private var id: Int = 0
	private var uuid: UUID? = null

	override fun readFromNBT(compound: NBTTagCompound) {
		id = compound.getInteger("id")
		uuid = compound.getUniqueId("uuid")
		super.readFromNBT(compound)
	}

	override fun writeToNBT(compound: NBTTagCompound): NBTTagCompound? {
		compound.setInteger("id", id)
		compound.setUniqueId("uuid", uuid)
		return super.writeToNBT(compound)
	}

	fun getSkill(): Int {
		return id
	}

	fun setSkill(Skill: Int) {
		id = Skill
	}

	fun getUUID(): UUID? {
		return uuid
	}

	fun setUUID(UUID: UUID){
		uuid = UUID
	}
}