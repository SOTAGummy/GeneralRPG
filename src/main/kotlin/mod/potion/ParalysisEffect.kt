package mod.potion

import mod.Core
import net.minecraft.client.Minecraft
import net.minecraft.util.ResourceLocation

class ParalysisEffect : GeneralRPGPotion("paralysis", 4980589) {
	override fun getStatusIconIndex(): Int {
		Minecraft.getMinecraft().textureManager.bindTexture(ResourceLocation(Core.ID, "textures/potion/paralysis.png"))
		return super.getStatusIconIndex()
	}
}