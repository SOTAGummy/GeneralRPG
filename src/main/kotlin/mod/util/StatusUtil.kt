package mod.util

import mod.capability.exp.ExpProvider
import mod.capability.maxmp.MaxMPProvider
import mod.capability.mp.MPProvider
import net.minecraft.entity.player.EntityPlayer
import kotlin.math.log

class StatusUtil {
	fun addMP(player: EntityPlayer, add: Int) {
		val mp = player.getCapability(MPProvider.MP_CAP!!, null)?.get() as Int
		val maxmp = player.getCapability(MaxMPProvider.MAX_MP_CAP!!, null)?.get() as Int
		if (mp + add >= maxmp) {
			player.getCapability(MPProvider.MP_CAP, null)?.set(maxmp)
		} else {
			player.getCapability(MPProvider.MP_CAP, null)?.set(mp + add)
		}
	}

	fun useMP(player: EntityPlayer, use: Int): Boolean {
		val mp = player.getCapability(MPProvider.MP_CAP!!, null)?.get() as Int
		if (player.isCreative) {
			return true
		} else {
			if (mp >= use) {
				player.getCapability(MPProvider.MP_CAP, null)?.set(mp - use)
				return true
			}
			return false
		}
	}

	fun getMaxMP(player: EntityPlayer): Int {
		return player.getCapability(MaxMPProvider.MAX_MP_CAP!!, null)?.get()!!.toInt()
	}

	fun getLevel(player: EntityPlayer): Int {
		val exp = player.getCapability(ExpProvider.EXP_CAP!!, null)?.get()!!.toDouble()
		return (log(0.1 * exp / 8, 1.1) + 1.0).toInt()
	}
}
