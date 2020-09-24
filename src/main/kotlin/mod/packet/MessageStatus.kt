package mod.packet

import io.netty.buffer.ByteBuf
import mod.capability.StatusProvider
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.nbt.NBTTagCompound
import net.minecraftforge.fml.common.network.ByteBufUtils
import net.minecraftforge.fml.common.network.simpleimpl.IMessage

class MessageStatus(val player: EntityPlayer): IMessage{
	val nbt = NBTTagCompound()

	override fun fromBytes(buf: ByteBuf?) {


	}

	override fun toBytes(buf: ByteBuf?) {
		ByteBufUtils.writeTag(buf, nbt)
	}
}