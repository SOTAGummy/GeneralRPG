package mod.event.entityEvent

import mod.Core
import mod.capability.accessory.AccessoryProvider
import net.minecraft.entity.ai.attributes.AttributeMap
import net.minecraft.entity.ai.attributes.AttributeModifier
import net.minecraft.item.ItemStack
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.TickEvent
import net.minecraftforge.fml.relauncher.Side

class PlayerEvents {
	companion object{
		val old = arrayOf(ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY)
		val slots = arrayOf(Core.necklace, Core.amulet, Core.glove, Core.gem)
		val attributeMap = AttributeMap()
	}

	@SubscribeEvent
	fun onPlayerTickEvent(event: TickEvent.PlayerTickEvent) {
		if (event.phase == TickEvent.Phase.START && event.side == Side.SERVER) {
			val player = event.player
			val cap = player.getCapability(AccessoryProvider.ACCESSORY!!, null)!!
			repeat(4){ i ->
				val item = cap.getItem(i)
				if (old[i] != item && old[i].isEmpty){
					//AttributeModifier付与
				}else if (old[i] != item && item.isEmpty){
					//AttributeModifier消去
				}else if (old[i] != item && !old[i].isEmpty && !item.isEmpty){
					//AttributeModifier付与 + 消去
				}
			old[i] = cap.getItem(i)
			}
		}
	}
}