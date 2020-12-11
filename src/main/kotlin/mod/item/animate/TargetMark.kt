package mod.item.animate

import mod.Core
import net.minecraft.item.Item
import net.minecraft.util.ResourceLocation

object TargetMark : Item() {
	init {
		this.unlocalizedName = "target_mark"
		this.registryName = ResourceLocation(Core.ID, "target_mark")
	}
}