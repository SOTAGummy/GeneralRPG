package mod.gui.accessory

import mod.Core
import mod.capability.accessory.AccessoryItemContainer
import net.minecraft.client.gui.inventory.GuiContainer
import net.minecraft.client.renderer.GlStateManager
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.ResourceLocation

class GuiAccessoryContainer(player: EntityPlayer, customInv: AccessoryItemContainer): GuiContainer(AccessoryContainer(player, customInv)){
	init {
		this.xSize = 22
		this.ySize = 85
	}

	override fun drawGuiContainerBackgroundLayer(partialTicks: Float, mouseX: Int, mouseY: Int) {
		val mc = this.mc
		if (mc.currentScreen.toString().split("@")[0] == "net.minecraft.client.gui.inventory.GuiInventory"){
			val width = this.width
			val height = this.height
			mc.textureManager.bindTexture(ResourceLocation("${Core.ID}:textures/gui/accessory.png"))
			GlStateManager.color(1F, 1F, 1F, 1F) //灰色かかるの防ぐ
			drawTexturedModalRect(width / 2 - 104, height / 2 - 83 , 0, 0, xSize, ySize)
		}
	}
}