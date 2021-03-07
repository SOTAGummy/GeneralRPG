package mod.capability

import mod.util.Attributes
import net.minecraft.entity.player.EntityPlayer

class Mp: IMp{
	var mpValue: Int = 100

	override fun getMp(): Int {
		return mpValue
	}

	override fun setMp(value: Int) {
	 this.mpValue = value
	}

	override fun addMp(player: EntityPlayer, value: Int) {
		if ((player.getCapability(MpProvider.MP!!, null)?.getMp()?.plus(value))!! <= player.getEntityAttribute(Attributes.MAXMP).attributeValue.toInt())
		this.mpValue += value
	}

	override fun useMp(value: Int): Boolean{
		return if (this.mpValue - value < 0){
			false
		} else {
			this.mpValue -= value
			true
		}
	}
}