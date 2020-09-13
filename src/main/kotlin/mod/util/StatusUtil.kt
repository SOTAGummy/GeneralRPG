package mod.util

import mod.capability.StatusProvider
import net.minecraft.entity.player.EntityPlayer

class StatusUtil {
	fun useMP(player: EntityPlayer, use: Int): Boolean {
		val mp = player.getCapability(StatusProvider.STATUS_CAP!!, null)?.getMp()!!
		if (player.isCreative) {
			return true
		} else {
			if (mp >= use) {
				player.getCapability(StatusProvider.STATUS_CAP, null)?.setMp(mp - use)
				return true
			}
			return false
		}
	}

	fun getMaxMP(player: EntityPlayer): Int {
		return player.getCapability(StatusProvider.STATUS_CAP!!, null)?.getMaxMp()!!
	}
}
