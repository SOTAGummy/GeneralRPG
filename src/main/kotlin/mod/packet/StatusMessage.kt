package mod.packet

import io.netty.buffer.ByteBuf
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.nbt.NBTTagCompound
import net.minecraftforge.fml.common.network.simpleimpl.IMessage

class StatusMessage(player: EntityPlayer) : IMessage{
	val nbt = NBTTagCompound()

	init {

	}

	override fun fromBytes(buf: ByteBuf?) {
		TODO("Not yet implemented")
	}

	override fun toBytes(buf: ByteBuf?) {
		TODO("Not yet implemented")
	}
}