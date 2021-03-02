package mod.event.capabilityEvent

import mod.Core
import mod.capability.MpProvider
import net.minecraft.entity.Entity
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.ResourceLocation
import net.minecraftforge.event.AttachCapabilitiesEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

class CapabilityEvent {
	@SubscribeEvent
	fun onAttachEvent(event: AttachCapabilitiesEvent<Entity>){
		if (event.`object` is EntityPlayer){
			event.addCapability(ResourceLocation(Core.ID, "mp"), MpProvider())
		}
	}
}