package mod.util

import mod.Core
import net.minecraft.entity.ai.attributes.IAttribute
import net.minecraft.entity.ai.attributes.RangedAttribute
import net.minecraft.inventory.EntityEquipmentSlot
import sun.misc.Unsafe
import sun.reflect.ConstructorAccessor
import java.lang.reflect.Constructor
import java.lang.reflect.Method
import java.lang.reflect.Field

object Attributes {
	val MP = addAttribute("mp", 100.0, 0.0, Double.MAX_VALUE)
	val MAXMP = addAttribute("maxmp", 100.0, 100.0, Double.MAX_VALUE)
	val EXP = addAttribute("exp", 0.0, 0.0, Double.MAX_VALUE)
	val LEVEL = addAttribute("level", 1.0, 1.0, Double.MAX_VALUE)
	val SAVINGRATE = addAttribute("savingrate", 0.0, 0.0, 80.0)
	val MPRECOVERRATE = addAttribute("mprecoverrate", 2.0, 2.0, Double.MAX_VALUE)
	val ELECTRICATTACK = addAttribute("electricattack", 0.0, 0.0, 1.0)
	val ELECTRICBODY = addAttribute("electricbody", 0.0, 0.0, 1.0)

	private fun addAttribute(name: String, baseValue: Double, minValue: Double, maxValue: Double): IAttribute {
		val attributes = RangedAttribute(null, "${Core.ID}.$name", baseValue, minValue, maxValue).setShouldWatch(true)
		Storage.Attributes.add(attributes)
		return attributes
	}
}






