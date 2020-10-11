package mod.packet

import mod.Core
import net.minecraftforge.fml.common.network.NetworkRegistry
import net.minecraftforge.fml.relauncher.Side

class PacketHandler {
	companion object{
		val INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Core.ID)
	}

	fun registerMessage() {
		INSTANCE.registerMessage(PlayerStatusMessageHandler::class.java, PlayerStatusMessage::class.java, 1, Side.CLIENT)
	}
}