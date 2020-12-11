package mod.proxy

import mod.Core
import mod.event.capabilityEvent.*
import mod.pppSystem.PPPSystem
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
		MinecraftForge.EVENT_BUS.register(ElementAttackEvent())
		MinecraftForge.EVENT_BUS.register(PPPSystem)
	}

	open fun postInit() {

	}

	open fun registerModel() {

	}

	open fun getEntityPlayerInstance(): EntityPlayer? {
		return null
	}
}