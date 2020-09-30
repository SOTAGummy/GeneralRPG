package mod.gui.mpindicator

import mod.Core
import mod.capability.StatusProvider
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.Gui
import net.minecraft.client.gui.ScaledResolution
import net.minecraft.util.ResourceLocation
import java.awt.Color

class MPIndicator(mc: Minecraft) : Gui() {
	companion object {
		@JvmStatic
		private val texture = ResourceLocation(Core.ID + ":textures/gui/mp_bar.png")
	}

	init {
		val player = mc.player
		val MP = player.getCapability(StatusProvider.STATUS_CAP!!, null)?.getMp()
		val MaxMP = player.getCapability(StatusProvider.STATUS_CAP, null)?.getMaxMp()
		val scaled = ScaledResolution(mc)
		val width = scaled.scaledWidth
		val height = scaled.scaledHeight
		val hp = (mc.player.health + 0.999999).toInt().toString() + "/" + mc.player.maxHealth.toInt().toString()
		val mp = player.getCapability(StatusProvider.STATUS_CAP, null)?.getMp().toString() + "/" + player.getCapability(StatusProvider.STATUS_CAP, null)?.getMaxMp().toString()
		val currentMP = ((MP!!.toFloat() / MaxMP!!.toFloat()) * 81).toInt()

		mc.textureManager.bindTexture(texture)
		this.drawTexturedModalRect(width / 2 + 10, height - 48, 0, 0, 81, 8)
		this.drawTexturedModalRect(width / 2 + 11, height - 47, 0, 8, currentMP, 8)
		mc.ingameGUI.drawCenteredString(mc.fontRenderer, hp, width / 2 - 48, height - 40, Color.WHITE.rgb)
		mc.ingameGUI.drawCenteredString(mc.fontRenderer, mp, width / 2 + 50, height - 48, Color.WHITE.rgb)
	}
}