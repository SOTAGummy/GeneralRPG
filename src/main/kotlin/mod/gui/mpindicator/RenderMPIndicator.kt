package mod.gui.mpindicator

import net.minecraft.client.Minecraft
import net.minecraftforge.client.event.RenderGameOverlayEvent
import net.minecraftforge.fml.common.eventhandler.EventPriority
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

@SideOnly(Side.CLIENT)
class RenderMPIndicator {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	fun onRenderGui(event: RenderGameOverlayEvent.Post) {
		if (event.type == RenderGameOverlayEvent.ElementType.EXPERIENCE && !Minecraft.getMinecraft().player.isCreative) {
			MPIndicator(Minecraft.getMinecraft())
		}
	}
}