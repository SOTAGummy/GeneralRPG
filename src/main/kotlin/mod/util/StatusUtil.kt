package mod.util

import mod.Core
import net.minecraft.entity.ai.attributes.AttributeModifier
import net.minecraft.entity.player.EntityPlayer
import java.util.*

object StatusUtil {
	fun canLevelUp(player: EntityPlayer) {
		player.let {
			if (player.getEntityAttribute(Core.LEVEL).attributeValue.toInt() <= 15) {
				if (player.getEntityAttribute(Core.LEVEL).attributeValue * 17 <= player.getEntityAttribute(Core.EXP).attributeValue) {
					val difference =
						player.getEntityAttribute(Core.EXP).attributeValue - player.getEntityAttribute(Core.LEVEL).attributeValue * 17
					val mod = AttributeModifier(UUID.randomUUID(), "exp", difference, 0)
					player.getEntityAttribute(Core.EXP).removeAllModifiers()
					player.getEntityAttribute(Core.EXP).applyModifier(mod)
					val add = AttributeModifier(UUID.randomUUID(), "level", 1.0, 0)
					player.getEntityAttribute(Core.LEVEL).applyModifier(add)
				}
			} else {
				val level = player.getEntityAttribute(Core.LEVEL).attributeValue
				val exp = player.getEntityAttribute(Core.EXP).attributeValue
				if ((1.5 * level * level + 15.5 * level + 255.0) <= exp) {
					val difference =
						player.getEntityAttribute(Core.EXP).attributeValue - (1.5 * level * level + 15.5 * level + 255.0)
					val mod = AttributeModifier(UUID.randomUUID(), "exp", difference, 0)
					player.getEntityAttribute(Core.EXP).removeAllModifiers()
					player.getEntityAttribute(Core.EXP).applyModifier(mod)
					val add = AttributeModifier(UUID.randomUUID(), "level", 1.0, 0)
					player.getEntityAttribute(Core.LEVEL).applyModifier(add)
				}
			}
		}
	}
}
