package mod.event.capabilityEvent


import mod.capability.StatusProvider
import net.minecraftforge.event.entity.player.PlayerEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

class CapabilityCloneEvent {
	@SubscribeEvent
	fun onPlayerClone(event: PlayerEvent.Clone) {
		val status = event.entityPlayer?.getCapability(StatusProvider.STATUS_CAP!!, null)!!
		val oldStatus = event.original.getCapability(StatusProvider.STATUS_CAP!!, null)!!

		status.setExp(oldStatus.getExp())
		status.setLevel(oldStatus.getLevel())
		status.setMp(oldStatus.getMp())
		status.setMaxMp(oldStatus.getMaxMp())
	}
}