package mod.util

import mod.Core
import net.minecraft.entity.SharedMonsterAttributes
import net.minecraft.entity.ai.attributes.IAttribute
import net.minecraft.entity.ai.attributes.RangedAttribute

object Attributes {
	val attributes = arrayOf<IAttribute>(
		SharedMonsterAttributes.ARMOR,
		SharedMonsterAttributes.ARMOR_TOUGHNESS,
		SharedMonsterAttributes.ATTACK_DAMAGE,
		SharedMonsterAttributes.ATTACK_SPEED,
		SharedMonsterAttributes.FLYING_SPEED,
		SharedMonsterAttributes.FOLLOW_RANGE,
		SharedMonsterAttributes.KNOCKBACK_RESISTANCE,
		SharedMonsterAttributes.LUCK,
		SharedMonsterAttributes.MAX_HEALTH,
		SharedMonsterAttributes.MOVEMENT_SPEED
	).plus(Storage.Attributes)

	fun addAttribute(name: String, baseValue: Double, minValue: Double, maxValue: Double): IAttribute {
		val attributes = RangedAttribute(null, "${Core.ID}.$name", baseValue, minValue, maxValue).setShouldWatch(true)
		Storage.Attributes.add(attributes)
		return attributes
	}
}






