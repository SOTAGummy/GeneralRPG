package mod.event.entityEvent

import mod.Core
import mod.capability.accessory.AccessoryProvider
import net.minecraft.item.ItemStack
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.TickEvent

class PlayerEvents {
	companion object{
		val accessories = arrayOf(ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY)
		val slots = arrayOf(Core.necklace, Core.amulet, Core.glove, Core.gem)
	}

	@SubscribeEvent
	fun onPlayerTickEvent(event: TickEvent.PlayerTickEvent) {
		if (event.phase == TickEvent.Phase.START) {
			val player = event.player
			val cap = player.getCapability(AccessoryProvider.ACCESSORY!!, null)
			repeat(4){
				accessories[it] = cap?.getItem(it)
				if (!accessories[it].isEmpty){

				}
			}
		}
	}
}