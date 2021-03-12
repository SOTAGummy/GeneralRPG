package mod.event.entityEvent

import mod.Core
import mod.capability.accessory.AccessoryProvider
import net.minecraft.item.ItemStack
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.TickEvent
import net.minecraftforge.fml.relauncher.Side

class PlayerEvents {
	companion object{
		val accessories = arrayOf(ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY)
		var old = arrayOf(ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY)
		val slots = arrayOf(Core.necklace, Core.amulet, Core.glove, Core.gem)
	}

	@SubscribeEvent
	fun onPlayerTickEvent(event: TickEvent.PlayerTickEvent) {
		if (event.phase == TickEvent.Phase.START && event.side == Side.SERVER) {
			val player = event.player
			val cap = player.getCapability(AccessoryProvider.ACCESSORY!!, null)
			repeat(4){ i ->
				accessories[i] = cap?.getItem(i)
				if (old[i].isEmpty && !accessories[i].isEmpty){
					player.attributeMap.applyAttributeModifiers(accessories[i].getAttributeModifiers(slots[i]))
				}else if (!old[i].isEmpty && accessories[i].isEmpty){
					player.attributeMap.removeAttributeModifiers(old[i].getAttributeModifiers(slots[i]))
				}else if (!old[i].isEmpty && !accessories[i].isEmpty){
					player.attributeMap.removeAttributeModifiers(old[i].getAttributeModifiers(slots[i]))
					player.attributeMap.applyAttributeModifiers(accessories[i].getAttributeModifiers(slots[i]))
				}
			}

			old = accessories
		}
	}
}