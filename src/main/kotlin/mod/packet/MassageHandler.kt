package mod.packet

import net.minecraftforge.fml.common.network.simpleimpl.IMessage
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext

class MassageHandler: IMessageHandler<StatusMessage, IMessage>{
	override fun onMessage(message: StatusMessage?, ctx: MessageContext?): IMessage {
		TODO("Not yet implemented")
	}
}