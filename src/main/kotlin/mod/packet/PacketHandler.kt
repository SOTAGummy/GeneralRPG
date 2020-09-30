package mod.packet

import mod.Core
import net.minecraftforge.fml.common.network.NetworkRegistry
import net.minecraftforge.fml.relauncher.Side

class PacketHandler {
	val INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Core.ID + "message")

	fun Initialization() {
		INSTANCE.registerMessage(StatusMessageHandler::class.java, StatusMessage::class.java, 34, Side.CLIENT)
	}
}