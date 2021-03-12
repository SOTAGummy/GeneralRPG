package mod.packet

import mod.Core
import net.minecraftforge.fml.common.network.NetworkRegistry
import net.minecraftforge.fml.relauncher.Side

class PacketHandler {
	companion object{
		@JvmField
		val INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Core.ID)

		@JvmStatic
		fun register(){
			INSTANCE.registerMessage(ClientMessageHandler::class.java, ClientPacket::class.java, 0, Side.CLIENT)
		}
	}
}