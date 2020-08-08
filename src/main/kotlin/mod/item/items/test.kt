package mod.item.items

import mod.Core
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item
import net.minecraft.util.ResourceLocation

object Test : Item() {
    init {
        this.unlocalizedName = "test"
        this.creativeTab = Core.creativeaTab
        this.maxStackSize = 1
        this.registryName = ResourceLocation(Core.ID,"test")
    }
}