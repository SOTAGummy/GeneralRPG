package mod.event.capabilityEvent

import mod.Core
import mod.capability.level.LevelProvider
import net.minecraft.client.Minecraft
import net.minecraftforge.event.entity.living.LivingDeathEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

class LevelUpTest {
	@SubscribeEvent
	fun onDeathEvent(event: LivingDeathEvent) {
		if (event.source.getDamageType() == "player") {
			val player = Minecraft.getMinecraft().player
			player.getCapability(LevelProvider.LEVEL_CAP!!, null)?.add()
			println(Core.heal.unlocalizedName)
		}
	}
}