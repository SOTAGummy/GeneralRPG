package mod.util

import net.minecraft.inventory.EntityEquipmentSlot
import sun.misc.Unsafe
import sun.reflect.ConstructorAccessor
import java.lang.reflect.Constructor
import java.lang.reflect.Field
import java.lang.reflect.Method

object SlotExtension {
	fun addSlotType(name: String, ordinal: Int, index: Int, slotIndex: Int, nameln: String): EntityEquipmentSlot {
		val method: Method = Constructor::class.java.getDeclaredMethod("acquireConstructorAccessor")
		method.isAccessible = true

		val cls: Constructor<out EntityEquipmentSlot> = EntityEquipmentSlot::class.java.getDeclaredConstructor(String::class.java, Int::class.java, EntityEquipmentSlot.Type::class.java, Int::class.java, Int::class.java, String::class.java)
		val ca: ConstructorAccessor = method.invoke(cls) as ConstructorAccessor

		val result: EntityEquipmentSlot = ca.newInstance(arrayOf<Any>(name, ordinal, EntityEquipmentSlot.Type.ARMOR, index, slotIndex, nameln)) as EntityEquipmentSlot
		addValueToEnum(result)
		return result
	}

	private fun addValueToEnum(value: EntityEquipmentSlot) {
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
}