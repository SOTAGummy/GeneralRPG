package mod.packet

import io.netty.buffer.ByteBuf
import mod.capability.accessory.AccessoryProvider
import mod.capability.mp.MpProvider
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.nbt.NBTTagCompound
import net.minecraftforge.fml.common.network.ByteBufUtils
import net.minecraftforge.fml.common.network.simpleimpl.IMessage

class ClientPacket(player: EntityPlayer): IMessage{
	var nbt = NBTTagCompound()

	init {
		player.getCapability(MpProvider.MP!!, null)?.getMp()?.let { nbt.setInteger("mp", it) }
		player.getCapability(AccessoryProvider.ACCESSORY!!, null)?.getItem(0)?.let { nbt.setTag("necklace", it.writeToNBT(NBTTagCompound())) }
		player.getCapability(AccessoryProvider.ACCESSORY, null)?.getItem(1)?.let { nbt.setTag("amulet", it.writeToNBT(NBTTagCompound())) }
		player.getCapability(AccessoryProvider.ACCESSORY, null)?.getItem(2)?.let { nbt.setTag("glove", it.writeToNBT(NBTTagCompound())) }
		player.getCapability(AccessoryProvider.ACCESSORY, null)?.getItem(3)?.let { nbt.setTag("gem", it.writeToNBT(NBTTagCompound())) }
	}

	override fun fromBytes(buf: ByteBuf?) {
		nbt = ByteBufUtils.readTag(buf)!!
	}

	override fun toBytes(buf: ByteBuf?) {
		ByteBufUtils.writeTag(buf, nbt)
	}
}