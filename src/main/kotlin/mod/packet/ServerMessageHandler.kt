package mod.packet

import net.minecraftforge.fml.common.network.simpleimpl.IMessage
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext

class ServerMessageHandler: IMessageHandler<ServerPacket, IMessage>{
	override fun onMessage(message: ServerPacket?, ctx: MessageContext?): IMessage? {
		val uuidString = message?.uuid
		val player = ctx?.serverHandler?.player

		if (player?.uniqueID.toString() == uuidString){
			return ClientPacket(player!!)
		}
		return null
	}
}