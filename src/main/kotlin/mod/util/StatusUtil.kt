package mod.util

import net.minecraft.entity.ai.attributes.AttributeModifier
import net.minecraft.entity.ai.attributes.IAttribute
import net.minecraft.entity.player.EntityPlayer
import java.util.*

object StatusUtil {
	fun useMP(player: EntityPlayer, use: Double, savingRate: Double): Boolean {
		val mp = player.getEntityAttribute(Attributes.MP).attributeValue.toInt()
		val cost = (use * ((100.0 - savingRate) / 100.0))
		if (player.isCreative) {
			return true
		} else {
			if (mp >= cost) {
				val mod = AttributeModifier(UUID.randomUUID(), "mp", -cost, 0)
				player.getEntityAttribute(Attributes.MP).applyModifier(mod)
				return true
			}
			return false
		}
	}

	fun addAttributeValue(player: EntityPlayer, attribute: IAttribute, amount: Double) {
		val mod = AttributeModifier(UUID.randomUUID(), attribute.name, amount, 0)
		player.getEntityAttribute(attribute).applyModifier(mod)
	}
}
