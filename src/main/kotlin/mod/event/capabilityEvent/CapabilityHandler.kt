package mod.event.capabilityEvent

import mod.Core
import mod.capability.StatusProvider
import net.minecraft.entity.Entity
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.ResourceLocation
import net.minecraftforge.event.AttachCapabilitiesEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

class CapabilityHandler {
	companion object {
		val STATUS_CAP = ResourceLocation(Core.ID, "status")

	}

	@SubscribeEvent
	fun attachCapability(event: AttachCapabilitiesEvent<Entity?>) {
		if (event.getObject() is EntityPlayer) {
			event.addCapability(STATUS_CAP, StatusProvider())
		}
	}
}