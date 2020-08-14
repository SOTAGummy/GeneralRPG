package mod.event.capabilityEvent

import mod.capability.exp.ExpProvider
import mod.capability.exp.IExp
import mod.capability.maxmp.IMaxMP
import mod.capability.maxmp.MaxMPProvider
import mod.capability.mp.IMP
import mod.capability.mp.MPProvider
import net.minecraftforge.event.entity.player.PlayerEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

class CapabilityCloneEvent {
	@SubscribeEvent
	fun onPlayerClone(event: PlayerEvent.Clone) {
		val mp: IMP? = event.entityPlayer?.getCapability(MPProvider.MP_CAP!!, null)
		val oldmp: IMP? = event.original.getCapability(MPProvider.MP_CAP!!, null)

		val exp: IExp? = event.entityPlayer?.getCapability(ExpProvider.EXP_CAP!!, null)
		val oldexp: IExp? = event.original.getCapability(ExpProvider.EXP_CAP!!, null)

		val maxmp: IMaxMP? = event.entityPlayer?.getCapability(MaxMPProvider.MAX_MP_CAP!!, null)
		val oldmaxmp: IMaxMP? = event.original.getCapability(MaxMPProvider.MAX_MP_CAP!!, null)

		mp?.set(oldmp!!.get())
		exp?.set(oldexp!!.get())
		maxmp?.set(oldmaxmp!!.get())
	}
}