package mod.util

import mod.item.baseitem.ItemAccessory
import net.minecraft.entity.ai.attributes.AttributeModifier
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.EntityEquipmentSlot
import java.util.*

object StatusUtil {
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
