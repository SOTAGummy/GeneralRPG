package mod.packet

import mod.Core
import mod.capability.StatusProvider
import net.minecraftforge.fml.common.network.simpleimpl.IMessage
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext

class StatusMessageHandler : IMessageHandler<StatusMessage, IMessage> {
	override fun onMessage(message: StatusMessage?, ctx: MessageContext?): IMessage? {
		Core.proxy.getEntityPlayerInstance()!!.getCapability(StatusProvider.STATUS_CAP!!, null)
		return null
	}
}