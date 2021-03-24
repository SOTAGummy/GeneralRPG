package mod.packet

import mod.Core
import net.minecraftforge.fml.common.network.NetworkRegistry
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper
import net.minecraftforge.fml.relauncher.Side

class PacketHandler {
	companion object{
		@JvmField
		val INSTANCE: SimpleNetworkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel(Core.ID)

		@JvmStatic
		fun register(){
			INSTANCE.registerMessage(PacketOpenAccessoryGui::class.java, PacketOpenAccessoryGui::class.java, 0, Side.SERVER)
			INSTANCE.registerMessage(MpMessageHandler::class.java, MpMessage::class.java, 2, Side.CLIENT)
		}
	}
}