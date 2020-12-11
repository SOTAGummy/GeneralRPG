package mod.potion

import mod.Core
import net.minecraft.client.Minecraft
import net.minecraft.util.ResourceLocation

class ElectricShockEffect : GeneralRPGPotion("electricshock", 16777023) {
	override fun getStatusIconIndex(): Int {
		Minecraft.getMinecraft().textureManager.bindTexture(
			ResourceLocation(
				Core.ID,
				"textures/potion/electricshock.png"
			)
		)
		return super.getStatusIconIndex()
	}
}