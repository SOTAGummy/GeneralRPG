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

	fun addSlotType(name: String, ordinal: Int, index: Int, slotIndex: Int, nameln: String): EntityEquipmentSlot{
		//メソッド取得
		val method: Method = Constructor::class.java.getDeclaredMethod("acquireConstructorAccessor")
		method.isAccessible = true
		//Enumのコンストラクター取得
		val cls: Constructor<out EntityEquipmentSlot> = EntityEquipmentSlot::class.java.getDeclaredConstructor(String::class.java, Int::class.java, EntityEquipmentSlot.Type::class.java, Int::class.java, Int::class.java, String::class.java)
		val ca: ConstructorAccessor = method.invoke(cls) as ConstructorAccessor

		val result: EntityEquipmentSlot = ca.newInstance(arrayOf<Any>(name, ordinal, EntityEquipmentSlot.Type.ARMOR, index, slotIndex, nameln)) as EntityEquipmentSlot
		addValueToEnum(result)
		return result
	}

	fun addValueToEnum(value: EntityEquipmentSlot) {
		val field: Field = value::class.java.getDeclaredField("\$VALUES")
		field.isAccessible = true
		@SuppressWarnings("unchecked")
		val values: Array<EntityEquipmentSlot> = field.get(null) as Array<EntityEquipmentSlot>
		val newValues = values.copyOf(values.size + 1)
		newValues[values.size] = value

		val uf: Field = Unsafe::class.java.getDeclaredField("theUnsafe")
		uf.isAccessible = true
		val unsafe: Unsafe = uf.get(null) as Unsafe
		unsafe.putObjectVolatile(unsafe.staticFieldBase(field), unsafe.staticFieldOffset(field), newValues)
	}

	init {
		addSlotType("ACCESSORY", 6, 0, 0, "accessory")
	}
}






