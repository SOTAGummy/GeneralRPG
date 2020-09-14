package mod.item.baseitem

import mod.Core
import mod.util.Storage
import net.minecraft.item.Item

open class GeneralRPGItem: Item() {
	init {
		this.creativeTab = Core.creativeaTab
		Storage.Items.add(this)
	}
}