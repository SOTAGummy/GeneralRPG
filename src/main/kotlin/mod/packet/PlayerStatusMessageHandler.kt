package mod.packet

import net.minecraftforge.fml.common.network.simpleimpl.IMessage
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext

class PlayerStatusMessageHandler: IMessageHandler<PlayerStatusMessage, IMessage>{
	override fun onMessage(message: PlayerStatusMessage?, ctx: MessageContext?): IMessage? {
		val uuidString = message!!.getUuid();
		val player = ctx!!.serverHandler.player;
		if (player.gameProfile.id.toString() == uuidString) {
			return PlayerStatusMessage(player);
		}
		return null
	}
}