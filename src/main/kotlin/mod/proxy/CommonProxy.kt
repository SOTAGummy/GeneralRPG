package mod.proxy

import mod.Core
import mod.event.capabilityEvent.CapabilityCloneEvent
import mod.event.capabilityEvent.LevelUp
import mod.event.capabilityEvent.PlayerAttributeEvent
import mod.event.capabilityEvent.TickEvent
import net.minecraft.entity.player.EntityPlayer
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod

@Mod.EventBusSubscriber(modid = Core.ID)
open class CommonProxy {
	open fun preInit() {
	}

	open fun init() {
		MinecraftForge.EVENT_BUS.register(CapabilityCloneEvent())
		MinecraftForge.EVENT_BUS.register(LevelUp())
		MinecraftForge.EVENT_BUS.register(PlayerAttributeEvent())
		MinecraftForge.EVENT_BUS.register(TickEvent())
	}

	open fun postInit() {

	}

	open fun registerModel() {

	}

	open fun getEntityPlayerInstance(): EntityPlayer? {
		return null
	}
}