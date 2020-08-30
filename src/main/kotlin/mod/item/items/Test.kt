package mod.item.items

import mod.Core
import mod.item.baseitem.GeneralRPGItem
import net.minecraft.util.ResourceLocation

object Test : GeneralRPGItem() {
	init {
		this.unlocalizedName = "test"
		this.creativeTab = Core.creativeaTab
		this.maxStackSize = 1
		this.registryName = ResourceLocation(Core.ID, "test")
	}

}