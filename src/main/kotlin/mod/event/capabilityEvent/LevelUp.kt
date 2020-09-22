package mod.event.capabilityEvent

import net.minecraftforge.event.entity.living.LivingDeathEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

class LevelUp {
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	fun onDeathEvent(event: LivingDeathEvent) {
		val source = event.source
		val type = source.damageType
		if (type == "player" || type == "explosion.player") {

		}
	}
}