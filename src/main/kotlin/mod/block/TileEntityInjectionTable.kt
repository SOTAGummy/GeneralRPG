package mod.block

import net.minecraft.nbt.NBTTagCompound
import net.minecraft.tileentity.TileEntity


class TileEntityInjectionTable: TileEntity(){
	companion object{
		private var skill: Int = -1
	}

	override fun readFromNBT(compound: NBTTagCompound) {
		skill = compound.getInteger("ID")
		super.readFromNBT(compound)
	}

	override fun writeToNBT(compound: NBTTagCompound): NBTTagCompound? {
		compound.setInteger("skill", skill)
		return super.writeToNBT(compound)
	}

	fun getSkill(): Int {
		return skill
	}

	fun setSkill(Skill: Int){
		skill = Skill
	}
}