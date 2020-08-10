package mod.proxy

import mod.gui.mpindicator.RenderMPIndicator
import net.minecraft.client.Minecraft
import net.minecraft.entity.player.EntityPlayer
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.event.FMLInitializationEvent

class ClientProxy : CommonProxy() {
	override fun getEntityPlayerInstance(): EntityPlayer? {
		return Minecraft.getMinecraft().player
	}

	fun init(event: FMLInitializationEvent) {
		MinecraftForge.EVENT_BUS.register(RenderMPIndicator())
	}
}
