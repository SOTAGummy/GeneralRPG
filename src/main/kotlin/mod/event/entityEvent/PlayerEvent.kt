package mod.event.entityEvent

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.TickEvent

class PlayerEvent {
	@SubscribeEvent
	fun onPlayerTickEvent(event: TickEvent.PlayerTickEvent) {
		if (event.phase == TickEvent.Phase.START) {
			val player = event.player

		}
	}
}