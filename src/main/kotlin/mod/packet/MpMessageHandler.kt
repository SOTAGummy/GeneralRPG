package mod.packet

import mod.Core
import mod.capability.mp.MpProvider
import net.minecraftforge.fml.common.network.simpleimpl.IMessage
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext

class MpMessageHandler: IMessageHandler<MpMessage, IMessage>{
	override fun onMessage(message: MpMessage?, ctx: MessageContext?): IMessage?{
		val nbt = message?.nbt
		val player = Core.proxy.getEntityPlayerInstance()
		nbt?.getInteger("mp")?.let { player?.getCapability(MpProvider.MP!!, null)?.setMp(it) }
		return null
	}
}