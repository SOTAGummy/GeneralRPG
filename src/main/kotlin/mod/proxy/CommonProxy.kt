package mod.proxy

import mod.Core
import net.minecraft.entity.player.EntityPlayer
import net.minecraftforge.fml.common.Mod

@Mod.EventBusSubscriber(modid = Core.ID)
open class CommonProxy {
	open fun preInit() {

	}

	open fun init() {

	}

	open fun postInit() {

	}

	open fun registerModel() {

	}

	open fun getEntityPlayerInstance(): EntityPlayer? {
		return null
	}
}