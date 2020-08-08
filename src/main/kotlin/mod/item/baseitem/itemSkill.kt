package mod.item.baseitem

import mod.Core
import net.minecraft.item.Item
import net.minecraft.util.ResourceLocation

open class itemSkill(name: String) : Item() {
	init {
		this.unlocalizedName = name
		this.creativeTab = Core.creativeaTab
		this.maxStackSize = 1
		this.registryName = ResourceLocation(Core.ID,name)
	}
}