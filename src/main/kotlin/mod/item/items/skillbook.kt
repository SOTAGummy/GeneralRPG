package mod.item.items

import mod.Core
import mod.item.baseitem.GeneralRPGItem
import net.minecraft.util.ResourceLocation

object SkillBook: GeneralRPGItem(){
	init {
		this.unlocalizedName = "skillbook"
		this.creativeTab = Core.creativeaTab
		this.maxStackSize = 1
		this.registryName = ResourceLocation(Core.ID,"skillbook")
	}
}