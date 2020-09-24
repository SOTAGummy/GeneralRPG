package mod.packet

import io.netty.buffer.ByteBuf
import net.minecraft.entity.player.EntityPlayer
import net.minecraftforge.fml.common.network.ByteBufUtils
import net.minecraftforge.fml.common.network.simpleimpl.IMessage

class PlayerStatusMessage(player: EntityPlayer): IMessage{
	private var uuid = ""

	init {
		uuid = player.gameProfile.id.toString()
	}

	override fun fromBytes(buf: ByteBuf?) {
		this.uuid = ByteBufUtils.readUTF8String(buf)
	}

	override fun toBytes(buf: ByteBuf?) {
		ByteBufUtils.writeUTF8String(buf, this.uuid)
	}

	fun getUuid(): String{
		return uuid
	}

	fun setUuid(uuid: String){
		this.uuid = uuid
	}
}