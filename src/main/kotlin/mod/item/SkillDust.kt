package mod.item

import mod.Core
import mod.item.baseitem.GeneralRPGItem
import net.minecraft.util.ResourceLocation

object SkillDust: GeneralRPGItem(){
	init {
		this.maxStackSize = 64
		this.unlocalizedName = "skill_dust"
		this.registryName = ResourceLocation(Core.ID, "skill_dust")
	}
}