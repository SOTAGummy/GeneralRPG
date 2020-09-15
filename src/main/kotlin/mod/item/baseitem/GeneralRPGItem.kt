package mod.item.baseitem

import mod.Core
import mod.util.Storage
import net.minecraft.item.Item

open class GeneralRPGItem: Item() {
	init {
		this.creativeTab = Core.modTab
		Storage.Items.add(this)
	}
}