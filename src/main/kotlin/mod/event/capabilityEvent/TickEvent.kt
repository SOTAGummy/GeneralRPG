package mod.event.capabilityEvent

import mod.capability.mp.MpProvider
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.PlayerEvent
import net.minecraftforge.fml.common.gameevent.TickEvent

class TickEvent {
	var count = 0

	@SubscribeEvent
	fun onTickEvent(event: TickEvent.PlayerTickEvent) {
		count++
		if (count >= 30 && event.phase == TickEvent.Phase.START) {
			count = 0
			event.player.getCapability(MpProvider.MP!!, null)?.addMp(event.player, 1)
		}
	}
}