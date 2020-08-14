package mod.event.capabilityEvent

import net.minecraft.client.Minecraft
import net.minecraftforge.event.entity.living.LivingDeathEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

class LevelUpTest {
	@SubscribeEvent
	fun onDeathEvent(event: LivingDeathEvent) {
		if (event.source.getDamageType() == "player") {
			val player = Minecraft.getMinecraft().player
			val entity = event.entityLiving
		}
	}
}