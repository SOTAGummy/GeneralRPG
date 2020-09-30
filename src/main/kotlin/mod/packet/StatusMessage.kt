package mod.packet

import io.netty.buffer.ByteBuf
import mod.capability.StatusProvider
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.nbt.NBTTagCompound
import net.minecraftforge.fml.common.network.ByteBufUtils
import net.minecraftforge.fml.common.network.simpleimpl.IMessage

class StatusMessage(val player: EntityPlayer) : IMessage {
	var nbt = NBTTagCompound()

	init {
		nbt = StatusProvider().serializeNBT() as NBTTagCompound
	}

	override fun fromBytes(buf: ByteBuf?) {
		nbt = ByteBufUtils.readTag(buf)!!
	}

	override fun toBytes(buf: ByteBuf?) {
		ByteBufUtils.writeTag(buf, nbt)
	}
}