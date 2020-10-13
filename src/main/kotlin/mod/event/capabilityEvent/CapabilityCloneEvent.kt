package mod.event.capabilityEvent


import mod.util.Storage
import net.minecraft.entity.ai.attributes.AttributeModifier
import net.minecraftforge.event.entity.player.PlayerEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import java.util.*

class CapabilityCloneEvent {
	@SubscribeEvent
	fun onPlayerClone(event: PlayerEvent.Clone) {
		repeat(Storage.Attributes.size) {
			val oldStatus = event.original.getEntityAttribute(Storage.Attributes[it]).attributeValue
			val status = event.entityPlayer?.getEntityAttribute(Storage.Attributes[it])
			val base = status?.baseValue
			val add = oldStatus - base!!
			val mod = AttributeModifier(UUID.randomUUID(), Storage.Attributes[it].name, add, 0)
			status.applyModifier(mod)
		}
	}
}