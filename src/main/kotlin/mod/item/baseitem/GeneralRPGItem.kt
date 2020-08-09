package mod.item.baseitem

import mod.util.Storage
import net.minecraft.item.Item

open class GeneralRPGItem: Item(){
	companion object{
		@JvmStatic
		var count = 0
	}

	init {
		count++
		Storage.Items?.add(this)
	}
}