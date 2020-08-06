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
		private val texture = ResourceLocation(Core.ID+"textures/mod.gui/mp_bar.png")
	}

	init {
		val player = mc.player
		val scaled = ScaledResolution(mc)
		val width = scaled.scaledWidth
		val height = scaled.scaledHeight
		val hp = (mc.player.health + 0.999999).toInt().toString() + "/" + mc.player.maxHealth.toInt().toString()
		val mana = player.getCapability(MPProvider.MP_CAP!!,null)?.get().toString() + "/" + player.getCapability(MaxMPProvider.MAX_MP_CAP!!,null)?.get().toString()

		mc.textureManager.bindTexture(texture)
		this.drawTexturedModalRect(width/2+10,height-48,0,0,81,20)
		mc.ingameGUI.drawCenteredString(mc.fontRenderer,hp,width/2+-10,height-48, Color.WHITE.rgb)
		mc.ingameGUI.drawCenteredString(mc.fontRenderer,mana,width/2+30,height-48,4987)
	}
}