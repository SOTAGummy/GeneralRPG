package mod.potionEffect

import mod.Core
import net.minecraft.client.Minecraft
import net.minecraft.util.ResourceLocation

class FrozenEffect : GeneralRPGPotion("frozen", 8126463) {
	override fun getStatusIconIndex(): Int {
		Minecraft.getMinecraft().textureManager.bindTexture(ResourceLocation(Core.ID, "textures/potion/frozen.png"))
		return super.getStatusIconIndex()
	}
}