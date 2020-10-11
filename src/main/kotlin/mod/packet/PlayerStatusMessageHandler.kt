package mod.packet

import mod.capability.StatusProvider
import net.minecraftforge.fml.common.network.simpleimpl.IMessage
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext

class PlayerStatusMessageHandler : IMessageHandler<PlayerStatusMessage, IMessage> {
	override fun onMessage(message: PlayerStatusMessage?, ctx: MessageContext?): IMessage? {
		val player = ctx!!.serverHandler.player
		val nbt = message?.nbt!!
		val cap = player.getCapability(StatusProvider.STATUS_CAP!!, null)!!
		cap.setMp(nbt.getInteger("mp"))
		cap.setMaxMp(nbt.getInteger("maxmp"))
		cap.setExp(nbt.getInteger("exp"))
		cap.setLevel(nbt.getInteger("level"))
		return null
	}
}