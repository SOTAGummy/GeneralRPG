package mod.item.baseitem

import net.minecraft.item.Item

open class GeneralRPGItem: Item(){
	@JvmField
	var count = 0

	init {
		count++
	}
}