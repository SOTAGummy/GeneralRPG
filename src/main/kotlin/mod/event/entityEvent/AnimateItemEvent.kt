package mod.event.entityEvent

import mod.entity.AnimateItem
import net.minecraftforge.event.entity.item.ItemExpireEvent

class AnimateItemEvent {
	fun DespawnItemEvent(event: ItemExpireEvent){
		if (event.entity is AnimateItem){
			event.extraLife = Int.MAX_VALUE
		}
	}
}