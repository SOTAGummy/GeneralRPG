package mod.item.baseitem

import mod.Core
import mod.util.Storage
import net.minecraft.item.ItemFood
import net.minecraft.util.ResourceLocation

open class GeneralRPGFood(amount: Int, saturation: Float, isWolfFood: Boolean, name: String): ItemFood(amount, saturation, isWolfFood) {
	init {
		this.maxStackSize = 64
		this.unlocalizedName = name
		this.registryName = ResourceLocation(Core.ID, name)
		this.creativeTab = Core.modTab

		Storage.Items.add(this)
	}
}