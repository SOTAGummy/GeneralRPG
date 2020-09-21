package mod.event.capabilityEvent

import net.minecraftforge.event.entity.living.LivingDeathEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

class LevelUp {
	@SubscribeEvent
	fun onDeathEvent(event: LivingDeathEvent) {
		val source = event.source
		val type = source.damageType
		if (type == "player" || type == "explosion.player") {
			//val player = event.entity as EntityPlayer
			//player.getCapability(StatusProvider.STATUS_CAP!!, null)?.addExp((event.entityLiving.maxHealth / 4F).toInt() * 10 + 1)
			//println(player.getCapability(StatusProvider.STATUS_CAP!!, null)?.getExp())
			//if (StatusUtil().canLevelUp(player)){
				//player.getCapability(StatusProvider.STATUS_CAP, null)?.addLevel(1)
				//player.getCapability(StatusProvider.STATUS_CAP, null)?.setExp(0)
				//player.sendMessage(TextComponentTranslation("text.level_up"))
			//}
		}
	}
}