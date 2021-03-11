package mod.util

import mod.Core
import net.minecraft.entity.ai.attributes.IAttribute
import net.minecraft.entity.ai.attributes.RangedAttribute

object Attributes {
	fun addAttribute(name: String, baseValue: Double, minValue: Double, maxValue: Double): IAttribute {
		val attributes = RangedAttribute(null, "${Core.ID}.$name", baseValue, minValue, maxValue).setShouldWatch(true)
		Storage.Attributes.add(attributes)
		return attributes
	}
}






