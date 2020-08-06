package mod.proxy

import mod.Core
import net.minecraft.entity.player.EntityPlayer
import net.minecraftforge.fml.common.Mod

@Mod.EventBusSubscriber(modid = Core.ID)
open class CommonProxy {
    fun preInit(){

    }

    open fun init(){

    }

    fun postInit(){

    }

    open fun getEntityPlayerInstance(): EntityPlayer? {
        return null
    }
}