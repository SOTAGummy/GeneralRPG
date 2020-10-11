package mod.event.capabilityEvent

import mod.capability.StatusProvider
import mod.util.Storage
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.TickEvent

class TickEvent {
	var count = 0

	@SubscribeEvent
	fun onTickEvent(event: TickEvent.PlayerTickEvent) {
		count++
		if (count >= 80) {
			count = 0
			event.player.getCapability(StatusProvider.STATUS_CAP!!, null)?.addMp(2)
			println(event.player.getCapability(StatusProvider.STATUS_CAP, null)?.getMaxMp())
		}
	}
}