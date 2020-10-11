package mod.packet

import io.netty.buffer.ByteBuf
import mod.capability.StatusProvider
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.nbt.NBTTagCompound
import net.minecraftforge.fml.common.network.ByteBufUtils
import net.minecraftforge.fml.common.network.simpleimpl.IMessage

class PlayerStatusMessage(player: EntityPlayer): IMessage {
	var nbt = NBTTagCompound()

	init {
		val cap = player.getCapability(StatusProvider.STATUS_CAP!!, null)!!
		nbt.setInteger("mp", cap.getMp())
		nbt.setInteger("maxmp", cap.getMaxMp())
		nbt.setInteger("exp", cap.getExp())
		nbt.setInteger("level", cap.getLevel())
	}

	override fun fromBytes(buf: ByteBuf?) {
		nbt = ByteBufUtils.readTag(buf)!!
	}

	override fun toBytes(buf: ByteBuf?) {
		ByteBufUtils.writeTag(buf, nbt)
	}
}