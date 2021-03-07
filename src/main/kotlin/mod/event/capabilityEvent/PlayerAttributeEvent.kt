package mod.event.capabilityEvent

import mod.capability.MpProvider
import mod.util.Attributes
import mod.util.Storage
import net.minecraft.entity.SharedMonsterAttributes
import net.minecraft.entity.player.EntityPlayer
import net.minecraftforge.event.entity.EntityEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.PlayerEvent

class PlayerAttributeEvent {
	@SubscribeEvent
	fun onJoinEvent(event: PlayerEvent.PlayerLoggedInEvent) {
		event.player.getCapability(MpProvider.MP!!, null)?.setMp(event.player.getEntityAttribute(Attributes.MAXMP).attributeValue.toInt())
	}

	@SubscribeEvent
	fun onConstructEvent(event: EntityEvent.EntityConstructing) {
		if (event.entity is EntityPlayer) {
			val player = event.entity as EntityPlayer
			repeat(Storage.Attributes.size) {
				player.attributeMap.registerAttribute(Storage.Attributes[it])
			}
		}
	}
}