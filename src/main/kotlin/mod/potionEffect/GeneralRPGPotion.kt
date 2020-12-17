package mod.potionEffect

import mod.Core
import mod.util.Storage
import net.minecraft.potion.Potion
import net.minecraft.util.ResourceLocation
import net.minecraft.util.text.TextComponentTranslation

open class GeneralRPGPotion(name: String, color: Int) : Potion(true, color) {
	init {
		this.registryName = ResourceLocation(Core.ID, name)
		this.setPotionName(TextComponentTranslation("potion.$name.name").unformattedText)
		this.setIconIndex(0, 0)
		Storage.Effects.add(this)
	}
}