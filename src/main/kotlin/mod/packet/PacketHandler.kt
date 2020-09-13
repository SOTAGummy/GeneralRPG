package mod.packet

import mod.Core
import net.minecraftforge.fml.common.network.NetworkRegistry
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper
import net.minecraftforge.fml.relauncher.Side

class PacketHandler {
	val INSTANCE: SimpleNetworkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel(Core.ID)

	fun Init(){
		INSTANCE.registerMessage(MassageHandler::class.java, StatusMessage::class.java, 0, Side.CLIENT)
	}
}