package mod

import mod.block.InjectionTable
import mod.block.TileEntityInjectionTable
import mod.capability.exp.Exp
import mod.capability.exp.ExpStorage
import mod.capability.exp.IExp
import mod.capability.maxmp.IMaxMP
import mod.capability.maxmp.MaxMP
import mod.capability.maxmp.MaxMPStorage
import mod.capability.mp.IMP
import mod.capability.mp.MP
import mod.capability.mp.MPStorage
import mod.event.bindSkillEvent.BindSkillEvent
import mod.event.capabilityEvent.CapabilityCloneEvent
import mod.event.capabilityEvent.CapabilityHandler
import mod.event.capabilityEvent.LevelUpTest
import mod.gui.mpindicator.RenderMPIndicator
 import mod.item.items.SkillBook
import mod.item.items.Test
import mod.item.skill.skills.Fulfill
import mod.item.skill.skills.Heal
import mod.item.skill.skills.Rage
import mod.item.skill.skills.ToggleMode
import mod.proxy.CommonProxy
import mod.tab.GeneralRPGSkillTab
import mod.tab.GeneralRPGTab
import mod.util.Storage
import net.minecraft.block.Block
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item
import net.minecraft.item.ItemBlock
import net.minecraft.util.ResourceLocation
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.client.model.ModelLoader
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
import net.minecraftforge.fml.common.registry.GameRegistry
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly


@Mod(modid = Core.ID, name = Core.Name, version = Core.version, modLanguage = "kotlin")

class Core{
	companion object {
		const val ID = "general-rpg"
		const val Name = "GeneralRPG"
		const val version = "1.0"

		@SidedProxy(clientSide = "mod.proxy.ClientProxy", serverSide = "mod.proxy.ServerProxy")
		@JvmStatic
		lateinit var proxy: CommonProxy

		@Mod.Instance(ID)
		var instance: Core? = null

		var creativeaTab: CreativeTabs = GeneralRPGTab()
		var skillTab: CreativeTabs = GeneralRPGSkillTab()

		val heal = Heal
		val fulfill = Fulfill
		val rage = Rage
		val togglemode = ToggleMode
		val test = Test
		val skillbook = SkillBook

		val injection_table = InjectionTable()
	}

	@Mod.EventHandler
	fun construct(event: FMLConstructionEvent?) {
		MinecraftForge.EVENT_BUS.register(this)
		MinecraftForge.EVENT_BUS.register(proxy)
	}

	@Mod.EventHandler
	fun preInit(event: FMLPreInitializationEvent?) {
		proxy.preInit()
		if (event?.side?.isClient!!) {
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(injection_table), 0, ModelResourceLocation(ResourceLocation(ID, "injection_table"), "inventory"))
			GameRegistry.registerTileEntity(TileEntityInjectionTable::class.java, ResourceLocation(ID, "injection_table"))
		}
	}

	@Mod.EventHandler
	fun init(event: FMLInitializationEvent?) {
		CapabilityManager.INSTANCE?.register(IMaxMP::class.java, MaxMPStorage(), MaxMP::class.java)
		CapabilityManager.INSTANCE?.register(IExp::class.java, ExpStorage(), Exp::class.java)
		CapabilityManager.INSTANCE?.register(IMP::class.java, MPStorage(), MP::class.java)


		MinecraftForge.EVENT_BUS.register(CapabilityHandler())
		MinecraftForge.EVENT_BUS.register(CapabilityCloneEvent())
		MinecraftForge.EVENT_BUS.register(LevelUpTest())
		MinecraftForge.EVENT_BUS.register(BindSkillEvent())
	}

	@Mod.EventHandler
	fun postInit(event: FMLPostInitializationEvent?) {
		MinecraftForge.EVENT_BUS.register(RenderMPIndicator())
		proxy.postInit()
	}

	@SubscribeEvent
	fun registerItem(event: RegistryEvent.Register<Item?>?) {
		for (item in Storage.Items) {
			event?.registry?.register(item)
		}
		event?.registry?.register(ItemBlock(injection_table).setRegistryName(ResourceLocation(ID, "injection_table")))
	}

	@SubscribeEvent
	fun registerBlock(event: RegistryEvent.Register<Block?>?) {
		event?.registry?.register(injection_table)
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	fun registerModel(event: ModelRegistryEvent) {
		for (model in Storage.Items) {
			ModelLoader.setCustomModelResourceLocation(model, 0, ModelResourceLocation(ResourceLocation(ID, model.unlocalizedName.split(".")[1]), "inventory"))
		}
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(injection_table), 0, ModelResourceLocation(ResourceLocation(ID, "injection_table"), "inventory"))
	}
}