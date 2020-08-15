package mod.event.capabilityEvent

import net.minecraft.entity.SharedMonsterAttributes
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.PlayerEvent

class PlayerAttributeEvent {
	@SubscribeEvent
	fun onJoinEvent(event: PlayerEvent.PlayerLoggedInEvent) {
		event.player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).baseValue = 1.0
	}
}