package mod.packet

import mod.Core
import mod.capability.accessory.AccessoryProvider
import mod.capability.mp.MpProvider
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraftforge.fml.common.network.simpleimpl.IMessage
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext

class ClientMessageHandler: IMessageHandler<ClientPacket, IMessage>{
	override fun onMessage(message: ClientPacket?, ctx: MessageContext?): IMessage? {
		val nbt = message?.nbt
		val player = Core.proxy.getEntityPlayerInstance()
		nbt?.getInteger("mp")?.let { player?.getCapability(MpProvider.MP!!, null)?.setMp(it) }
		nbt?.getTag("necklace")?.let { player?.getCapability(AccessoryProvider.ACCESSORY!!, null)?.setItem(0, ItemStack(it as NBTTagCompound)) }
		nbt?.getTag("amulet")?.let { player?.getCapability(AccessoryProvider.ACCESSORY!!, null)?.setItem(1, ItemStack(it as NBTTagCompound)) }
		nbt?.getTag("glove")?.let { player?.getCapability(AccessoryProvider.ACCESSORY!!, null)?.setItem(2, ItemStack(it as NBTTagCompound)) }
		nbt?.getTag("gem")?.let { player?.getCapability(AccessoryProvider.ACCESSORY!!, null)?.setItem(3, ItemStack(it as NBTTagCompound)) }

		return null
	}
}