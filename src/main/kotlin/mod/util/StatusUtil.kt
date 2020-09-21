package mod.util

import mod.capability.StatusProvider
import net.minecraft.entity.player.EntityPlayer

class StatusUtil {
	fun useMP(player: EntityPlayer, use: Int, savingRate: Float): Boolean {
		val mp = player.getCapability(StatusProvider.STATUS_CAP!!, null)?.getMp()!!
		val cost = (use.toFloat() * ((100.0 - savingRate )/ 100.0)).toInt()
		if (player.isCreative) {
			return true
		} else {
			if (mp >= cost) {
				player.getCapability(StatusProvider.STATUS_CAP, null)?.setMp(mp - cost)
				return true
			}
			return false
		}
	}

	fun canLevelUp(player: EntityPlayer): Boolean{
		val exp = player.getCapability(StatusProvider.STATUS_CAP!!, null)?.getExp()!!
		val level = player.getCapability(StatusProvider.STATUS_CAP!!, null)?.getLevel()!!
		if (level < 17){
			if (level * 17 <= exp){
				return true
			}
		} else {
			if ((272 + ((level - 16) - 1) * 3 + 20) <= exp){
				return true
			}
		}
		return false
	}
}
