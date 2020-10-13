package mod.event.capabilityEvent

import mod.util.Attributes
import net.minecraft.entity.ai.attributes.AttributeModifier
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.TickEvent
import java.util.*

class TickEvent {
	var count = 0

	@SubscribeEvent
	fun onTickEvent(event: TickEvent.PlayerTickEvent) {
		count++
		if (count >= 80) {
			count = 0
			if (event.player.getEntityAttribute(Attributes.MAXMP).attributeValue >= event.player.getEntityAttribute(Attributes.MP).attributeValue + 2) {
				val amount = event.player.getEntityAttribute(Attributes.MPRECOVERRATE).attributeValue
				val mod = AttributeModifier(UUID.randomUUID(), "mp", amount, 0)
				event.player.getEntityAttribute(Attributes.MP).applyModifier(mod)
			}
		}
	}
}