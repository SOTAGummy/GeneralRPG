package mod.event.capabilityEvent


import mod.capability.MpProvider
import mod.util.Attributes
import mod.util.Storage
import net.minecraft.entity.ai.attributes.AttributeModifier
import net.minecraftforge.event.entity.player.PlayerEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import java.util.*

class CapabilityCloneEvent {
	@SubscribeEvent
	fun onPlayerClone(event: PlayerEvent.Clone) {
		val player = event.entityPlayer
		player.getCapability(MpProvider.MP!!, null)?.setMp(player.getEntityAttribute(Attributes.MAXMP).attributeValue.toInt())
	}
}