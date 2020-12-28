package mod.proxy

import mod.Core
import mod.gui.RenderHandler
import mod.util.Storage
import net.minecraft.client.Minecraft
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.Item
import net.minecraft.util.ResourceLocation
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.event.FMLInitializationEvent

class ClientProxy : CommonProxy() {
	override fun getEntityPlayerInstance(): EntityPlayer? {
		return Minecraft.getMinecraft().player
	}

	fun init(event: FMLInitializationEvent) {
		MinecraftForge.EVENT_BUS.register(RenderHandler())
	}

	override fun registerModel() {
		for (model in Storage.Items) {
			ModelLoader.setCustomModelResourceLocation(
				model,
				0,
				ModelResourceLocation(ResourceLocation(Core.ID, model.unlocalizedName.split(".")[1]), "inventory")
			)
		}
		ModelLoader.setCustomModelResourceLocation(
			Item.getItemFromBlock(Core.injection_table),
			0,
			ModelResourceLocation(ResourceLocation(Core.ID, "injection_table"), "inventory")
		)
	}
}
