package mod.event.capabilityEvent

import mod.Core
import mod.capability.exp.ExpProvider
import mod.capability.maxmp.MaxMPProvider
import mod.capability.mp.MPProvider
import net.minecraft.entity.Entity
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.ResourceLocation
import net.minecraftforge.event.AttachCapabilitiesEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

class CapabilityHandler {
	companion object {
		val MANA_CAP = ResourceLocation(Core.ID, "mp")
		val EXP_CAP = ResourceLocation(Core.ID, "exp")
		val MAX_MP_CAP = ResourceLocation(Core.ID, "max-mp")
	}

	@SubscribeEvent
	fun attachCapability(event: AttachCapabilitiesEvent<Entity?>) {
		if (event.getObject() is EntityPlayer) {
			event.addCapability(MANA_CAP, MPProvider())
			event.addCapability(EXP_CAP, ExpProvider())
			event.addCapability(MAX_MP_CAP, MaxMPProvider())
		}
	}
}