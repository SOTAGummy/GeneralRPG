package mod.potion

import mod.Core
import net.minecraft.client.Minecraft
import net.minecraft.util.ResourceLocation

class FloodedEffect : GeneralRPGPotion("flooded", 31231) {
	override fun getStatusIconIndex(): Int {
		Minecraft.getMinecraft().textureManager.bindTexture(ResourceLocation(Core.ID, "textures/potion/flooded.png"))
		return super.getStatusIconIndex()
	}
}