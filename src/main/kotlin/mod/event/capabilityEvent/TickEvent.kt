package mod.event.capabilityEvent

import mod.util.StatusUtil
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.TickEvent

class TickEvent {
	var count = 0

	@SubscribeEvent
	fun onTickEvent(event: TickEvent.PlayerTickEvent) {
		count++
		if (count == 80) {
			count = 0
			StatusUtil().addMP(event.player, 1)
		}
	}
}