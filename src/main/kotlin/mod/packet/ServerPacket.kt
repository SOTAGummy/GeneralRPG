package mod.packet

import io.netty.buffer.ByteBuf
import net.minecraft.entity.player.EntityPlayer
import net.minecraftforge.fml.common.network.ByteBufUtils
import net.minecraftforge.fml.common.network.simpleimpl.IMessage

class ServerPacket(player: EntityPlayer): IMessage{
	var uuid = ""

	init {
		uuid = player.uniqueID.toString()
	}

	override fun fromBytes(buf: ByteBuf?) {
		uuid = ByteBufUtils.readUTF8String(buf)
	}

	override fun toBytes(buf: ByteBuf?) {
		ByteBufUtils.writeUTF8String(buf, uuid)
	}
}