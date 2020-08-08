package mod.gui.mpindicator

import mod.Core
import mod.capability.maxmp.MaxMPProvider
import mod.capability.mp.MPProvider
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.Gui
import net.minecraft.client.gui.ScaledResolution
import net.minecraft.util.ResourceLocation
import java.awt.Color

class MPIndicator(mc: Minecraft) : Gui() {
	companion object{
		@JvmStatic
		private val texture = ResourceLocation(Core.ID+":textures/gui/mp_bar.png")
	}

	init {
		val player = mc.player
		var MP = player.getCapability(MPProvider.MP_CAP!!,null)?.get() as Int
		var MaxMP = player.getCapability(MaxMPProvider.MAX_MP_CAP!!,null)?.get() as Int
		val scaled = ScaledResolution(mc)
		val width = scaled.scaledWidth
		val height = scaled.scaledHeight
		val hp = (mc.player.health + 0.999999).toInt().toString() + "/" + mc.player.maxHealth.toInt().toString()
		val mp = player.getCapability(MPProvider.MP_CAP,null)?.get().toString() + "/" + player.getCapability(MaxMPProvider.MAX_MP_CAP,null)?.get().toString()
		var currentMP = (MP / MaxMP) * 80

		mc.textureManager.bindTexture(texture)
		this.drawTexturedModalRect(width/2+10,height-48,0,0,81,8)
		this.drawTexturedModalRect(width/2+11,height-47,0,8, currentMP,8)
		mc.ingameGUI.drawCenteredString(mc.fontRenderer,hp,width/2-48,height-40, Color.WHITE.rgb)
		mc.ingameGUI.drawCenteredString(mc.fontRenderer,mp,width/2+50,height-48,Color.WHITE.rgb)
	}
}