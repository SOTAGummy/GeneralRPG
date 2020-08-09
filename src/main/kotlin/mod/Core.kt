package mod

import mod.capability.exp.Exp
import mod.capability.exp.ExpStorage
import mod.capability.exp.IExp
import mod.capability.level.ILevel
import mod.capability.level.Level
import mod.capability.level.LevelStorage
import mod.capability.maxmp.IMaxMP
import mod.capability.maxmp.MaxMP
import mod.capability.maxmp.MaxMPStorage
import mod.capability.mp.IMP
import mod.capability.mp.MP
import mod.capability.mp.MPStorage
import mod.event.capabilityEvent.CapabilityCloneEvent
import mod.event.capabilityEvent.CapabilityHandler
import mod.event.capabilityEvent.LevelUpTest
import mod.gui.mpindicator.RenderMPIndicator
import mod.item.items.Heal
import mod.item.items.Test
import net.minecraft.item.Item
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.common.capabilities.CapabilityManager
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.SidedProxy
import net.minecraftforge.fml.common.event.FMLConstructionEvent
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import mod.proxy.CommonProxy
import mod.tab.GeneralRPGTab
import mod.util.Storage
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.util.ResourceLocation
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.client.model.ModelLoader

@Mod(modid = Core.ID,name = Core.Name,version = Core.version,modLanguage = "kotlin")

class Core {
	companion object {
		const val ID = "general-rpg"
		const val Name = "GeneralRPG"
		const val version = "1.0"

		@SidedProxy(clientSide = "mod.proxy.ClientProxy",serverSide = "mod.proxy.ServerProxy")
		@JvmStatic
		lateinit var proxy: CommonProxy

		var creativeaTab: CreativeTabs = GeneralRPGTab()

		val test: Item = Test
		val heal: Item = Heal
	}

	@Mod.EventHandler
	fun construct(event: FMLConstructionEvent?){
		MinecraftForge.EVENT_BUS.register(this)
		MinecraftForge.EVENT_BUS.register(proxy)
	}

	@Mod.EventHandler
	fun preInit(event: FMLPreInitializationEvent?){
		proxy.preInit()
	}

	@Mod.EventHandler
	fun init(event: FMLInitializationEvent?){
		CapabilityManager.INSTANCE?.register(IMaxMP::class.java, MaxMPStorage(), MaxMP::class.java)
		CapabilityManager.INSTANCE?.register(ILevel::class.java, LevelStorage(), Level::class.java)
		CapabilityManager.INSTANCE?.register(IExp::class.java, ExpStorage(), Exp::class.java)
		CapabilityManager.INSTANCE?.register(IMP::class.java, MPStorage(), MP::class.java)


		MinecraftForge.EVENT_BUS.register(CapabilityHandler())
		MinecraftForge.EVENT_BUS.register(CapabilityCloneEvent())
		MinecraftForge.EVENT_BUS.register(LevelUpTest())
	}

	@Mod.EventHandler
	fun postInit(event: FMLPostInitializationEvent?){
		MinecraftForge.EVENT_BUS.register(RenderMPIndicator())
		proxy.postInit()
	}

	@SubscribeEvent
	fun registerItem(event: RegistryEvent.Register<Item?>?){
		for (item in Storage.Items){
			event?.registry?.register(item)
		}
	}

	@SubscribeEvent
	fun registerModel(event: ModelRegistryEvent){
		for (model in Storage.Items){
			ModelLoader.setCustomModelResourceLocation(model,0, ModelResourceLocation(ResourceLocation(ID,model.unlocalizedName.split(".")[1]), "inventory"))
		}
	}
}