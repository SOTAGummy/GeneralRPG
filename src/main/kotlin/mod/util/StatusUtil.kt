package mod.util

import net.minecraft.entity.ai.attributes.AttributeModifier
import net.minecraft.entity.player.EntityPlayer
import java.util.*

object StatusUtil {
	fun useMP(player: EntityPlayer, use: Double): Boolean {
		val mp = player.getEntityAttribute(Attributes.MP).attributeValue.toInt()
		val savingRate = player.getEntityAttribute(Attributes.SAVINGRATE).attributeValue
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

	fun addMP(player: EntityPlayer, amount: Double) {
		val mp = player.getEntityAttribute(Attributes.MP).attributeValue
		val max = player.getEntityAttribute(Attributes.MAXMP).attributeValue
		if (mp + amount <= max) {
			val mod = AttributeModifier(UUID.randomUUID(), "mp", amount, 0)
			player.getEntityAttribute(Attributes.MP).applyModifier(mod)
		} else {
			val mod = AttributeModifier(UUID.randomUUID(), "mp", max - mp, 0)
			player.getEntityAttribute(Attributes.MP).applyModifier(mod)
		}
	}

	fun canLevelUp(player: EntityPlayer) {
		player.let {
			if (player.getEntityAttribute(Attributes.LEVEL).attributeValue.toInt() <= 15) {
				if (player.getEntityAttribute(Attributes.LEVEL).attributeValue * 17 <= player.getEntityAttribute(Attributes.EXP).attributeValue) {
					val difference =
						player.getEntityAttribute(Attributes.EXP).attributeValue - player.getEntityAttribute(Attributes.LEVEL).attributeValue * 17
					val mod = AttributeModifier(UUID.randomUUID(), "exp", difference, 0)
					player.getEntityAttribute(Attributes.EXP).removeAllModifiers()
					player.getEntityAttribute(Attributes.EXP).applyModifier(mod)
					val add = AttributeModifier(UUID.randomUUID(), "level", 1.0, 0)
					player.getEntityAttribute(Attributes.LEVEL).applyModifier(add)
				}
			} else {
				val level = player.getEntityAttribute(Attributes.LEVEL).attributeValue
				val exp = player.getEntityAttribute(Attributes.EXP).attributeValue
				if ((1.5 * level * level + 15.5 * level + 255.0) <= exp) {
					val difference =
						player.getEntityAttribute(Attributes.EXP).attributeValue - (1.5 * level * level + 15.5 * level + 255.0)
					val mod = AttributeModifier(UUID.randomUUID(), "exp", difference, 0)
					player.getEntityAttribute(Attributes.EXP).removeAllModifiers()
					player.getEntityAttribute(Attributes.EXP).applyModifier(mod)
					val add = AttributeModifier(UUID.randomUUID(), "level", 1.0, 0)
					player.getEntityAttribute(Attributes.LEVEL).applyModifier(add)
				}
			}
		}
	}
}
