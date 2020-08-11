package mod.block

import mod.Core
import net.minecraft.client.gui.inventory.GuiContainer
import net.minecraft.client.renderer.GlStateManager
import net.minecraft.inventory.IInventory
import net.minecraft.util.ResourceLocation

class InjectionTableGui(playerInv: IInventory, te: TileEntityInjectionTable) : GuiContainer(InjectionTableContainer(playerInv, te)) {
	init {
		this.xSize = 175
		this.ySize = 165
	}

	override fun drawGuiContainerBackgroundLayer(partialTicks: Float, mouseX: Int, mouseY: Int) {
		GlStateManager.color(1F, 1F, 1F, 1F)
		this.mc.textureManager.bindTexture(ResourceLocation(Core.ID, "textures/gui/injection_table_gui.png"))
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize)
	}
}