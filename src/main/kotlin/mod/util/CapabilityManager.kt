package mod.util

import mod.capability.maxmp.MaxMPProvider
import mod.capability.mp.MPProvider
import net.minecraft.entity.player.EntityPlayer

class CapabilityManager {
	fun addMP(player: EntityPlayer,add: Int){
		var mp = player.getCapability(MPProvider.MP_CAP!!,null)?.get() as Int
		var maxmp = player.getCapability(MaxMPProvider.MAX_MP_CAP!!,null)?.get() as Int
		if(mp + add >= maxmp){
			player.getCapability(MPProvider.MP_CAP,null)?.set(maxmp)
		}else{
			player.getCapability(MPProvider.MP_CAP,null)?.set(mp + add)
		}
	}
}