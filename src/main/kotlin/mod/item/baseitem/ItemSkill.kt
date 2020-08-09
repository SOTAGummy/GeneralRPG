package mod.item.baseitem

import mod.Core
import net.minecraft.util.ResourceLocation

open class ItemSkill(name: String) : GeneralRPGItem() {
	init {
		this.unlocalizedName = name
		this.creativeTab = Core.creativeaTab
		this.maxStackSize = 1
		this.registryName = ResourceLocation(Core.ID,name)
	}
}