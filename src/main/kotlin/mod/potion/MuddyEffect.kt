package mod.potion

import mod.Core
import net.minecraft.client.Minecraft
import net.minecraft.util.ResourceLocation

class MuddyEffect : GeneralRPGPotion("muddy", 5252096) {
	override fun getStatusIconIndex(): Int {
		Minecraft.getMinecraft().textureManager.bindTexture(ResourceLocation(Core.ID, "textures/potion/muddy.png"))
		return super.getStatusIconIndex()
	}
}