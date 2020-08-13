package mod.util

import mod.capability.maxmp.MaxMPProvider
import mod.capability.mp.MPProvider
import net.minecraft.entity.player.EntityPlayer

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

	fun useMP(player: EntityPlayer, use: Int) {
		val mp = player.getCapability(MPProvider.MP_CAP!!, null)?.get() as Int
		if (mp >= use) {
			player.getCapability(MPProvider.MP_CAP, null)?.set(mp - use)
		}
	}
}