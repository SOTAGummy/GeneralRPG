package mod.potionEffect

import mod.Core
import net.minecraft.client.Minecraft
import net.minecraft.util.ResourceLocation
import java.awt.Color

class BurningEffect : GeneralRPGPotion("burning", Color.RED.rgb) {
	override fun getStatusIconIndex(): Int {
		Minecraft.getMinecraft().textureManager.bindTexture(ResourceLocation(Core.ID, "textures/potion/burning.png"))
		return super.getStatusIconIndex()
	}
}