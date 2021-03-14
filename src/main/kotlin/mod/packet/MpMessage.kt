package mod.packet

import io.netty.buffer.ByteBuf
import mod.capability.mp.MpProvider
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.nbt.NBTTagCompound
import net.minecraftforge.fml.common.network.ByteBufUtils
import net.minecraftforge.fml.common.network.simpleimpl.IMessage

class MpMessage(player: EntityPlayer): IMessage{
	var nbt = NBTTagCompound()

	init {
		player.getCapability(MpProvider.MP!!, null)?.getMp()?.let { nbt.setInteger("mp", it) }
	}

	override fun fromBytes(buf: ByteBuf?) {
		nbt = ByteBufUtils.readTag(buf)!!
	}

	override fun toBytes(buf: ByteBuf?) {
		ByteBufUtils.writeTag(buf, nbt)
	}
}