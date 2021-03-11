package mod.event.capabilityEvent


import mod.Core
import mod.capability.mp.MpProvider
import net.minecraftforge.event.entity.player.PlayerEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

class CapabilityCloneEvent {
	@SubscribeEvent
	fun onPlayerClone(event: PlayerEvent.Clone) {
		val player = event.entityPlayer
		player.getCapability(MpProvider.MP!!, null)?.setMp(player.getEntityAttribute(Core.MAXMP).attributeValue.toInt())
	}
}