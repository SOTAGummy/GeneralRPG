package mod.gui

import mod.gui.accessory.button.AccessoryButton
import mod.gui.mpindicator.MPIndicator
import mod.gui.skilllist.SkillListIndicator
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.GuiButton
import net.minecraft.client.gui.inventory.GuiInventory
import net.minecraftforge.client.event.GuiScreenEvent
import net.minecraftforge.client.event.RenderGameOverlayEvent
import net.minecraftforge.fml.common.eventhandler.EventPriority
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

@SideOnly(Side.CLIENT)
class RenderHandler {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	fun onRenderGui(event: RenderGameOverlayEvent.Post) {
		if (event.type == RenderGameOverlayEvent.ElementType.EXPERIENCE && !Minecraft.getMinecraft().player.isCreative) {
			val mc = Minecraft.getMinecraft()
			var correction = 0
			if (event.type == RenderGameOverlayEvent.ElementType.AIR) correction = 8
			MPIndicator(mc, correction)
			SkillListIndicator(mc)
		}
	}

	@SubscribeEvent
	fun guiPostInit(event: GuiScreenEvent.InitGuiEvent.Post){
		if (event.gui is GuiInventory)
		event.buttonList.add(AccessoryButton(70, event.gui.mc.displayWidth / 2 - 314, event.gui.mc.displayHeight / 2 - 190, 12, 14, ""))
	}
}