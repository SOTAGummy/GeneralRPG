package mod.event.capabilityEvent

import net.minecraftforge.event.entity.living.LivingDeathEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

class LevelUp {
	@SubscribeEvent
	fun onDeathEvent(event: LivingDeathEvent) {
		if (event.source.damageType == "player" || event.source.damageType == "explosion.player" || event.source.damageType == "skill") {

		}
		println(event.source.damageType)
	}
}