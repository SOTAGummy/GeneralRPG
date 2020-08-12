package mod.block

import net.minecraft.nbt.NBTTagCompound
import net.minecraft.tileentity.TileEntity


class TileEntityInjectionTable: TileEntity(){
	companion object{
		private var skill = ""
	}

	override fun readFromNBT(compound: NBTTagCompound) {
		skill = compound.getString("skill")
		super.readFromNBT(compound)
	}

	override fun writeToNBT(compound: NBTTagCompound): NBTTagCompound? {
		compound.setString("skill", skill)
		return super.writeToNBT(compound)
	}

	fun getSkill(): String {
		return skill
	}

	fun setSkill(Skill: String){
		skill = Skill
	}
}