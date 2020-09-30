package mod

import mod.block.InjectionTable
import mod.block.TileEntityInjectionTable
import mod.capability.IStatus
import mod.capability.Status
import mod.capability.StatusStorage
import mod.entity.bullet.SkillBullet
import mod.event.capabilityEvent.*
import mod.gui.mpindicator.RenderMPIndicator
import mod.item.SkillDust
import mod.item.containers.*
import mod.item.fruit.LifeFruit
import mod.item.fruit.SkillFruit
import mod.item.skills.*
import mod.item.tokens.*
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
import net.minecraftforge.fml.common.registry.EntityEntry
import net.minecraftforge.fml.common.registry.EntityRegistry
import net.minecraftforge.fml.common.registry.GameRegistry
import java.util.concurrent.Callable


@Mod(modid = Core.ID, name = Core.Name, version = Core.version, modLanguage = "kotlin")

class Core {
	companion object {
		const val ID = "general-rpg"
		const val Name = "GeneralRPG"
		const val version = "1.0"

		@JvmStatic
		@SidedProxy(clientSide = "mod.proxy.ClientProxy", serverSide = "mod.proxy.ServerProxy")
		lateinit var proxy: CommonProxy

		@JvmStatic
		@Mod.Instance(ID)
		lateinit var instance: Core

		val modTab: CreativeTabs = GeneralRPGTab()
		val skillTab: CreativeTabs = GeneralRPGSkillTab()

		val skilldust = SkillDust

		val heal = Heal
		val healP = HealP
		val healPP = HealPP
		val rage = Rage
		val shield = Shield
		val leap = Leap
		val leapP = LeapP
		val leapPP = LeapPP
		val explosion = Explosion
		val arrowrain = ArrowRain
		val togglemode = ToggleMode
		val fulfill = Fulfill
		val light = Light
		val blackhole = BlackHole
		val blow = Blow

		val common_token = CommonToken
		val uncommon_token = UncommonToken
		val rare_token = RareToken
		val epic_token = EpicToken
		val legend_token = LegendToken

		val skillbook = SkillBook
		val skillstaff = SkillStaff
		val skillorb = SkillOrb
		val enderdragonartifact = EnderDragonArtifact
		val witherartifact = WitherArtifact

		val skill_fruit = SkillFruit
		val life_fruit = LifeFruit

		val injection_table = InjectionTable()
	}

	@Mod.EventHandler
	fun construct(event: FMLConstructionEvent?) {
		MinecraftForge.EVENT_BUS.register(this)
		MinecraftForge.EVENT_BUS.register(proxy)
		for (item in Storage.Instances) {
			MinecraftForge.EVENT_BUS.register(item)
		}
	}

	@Mod.EventHandler
	fun preInit(event: FMLPreInitializationEvent?) {
		proxy?.preInit()
		if (event?.side?.isClient!!) {
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(injection_table), 0, ModelResourceLocation(ResourceLocation(ID, "injection_table"), "inventory"))
		}
		GameRegistry.registerTileEntity(TileEntityInjectionTable::class.java, ResourceLocation(ID, "injection_table"))
	}

	@Mod.EventHandler
	fun init(event: FMLInitializationEvent?) {
		CapabilityManager.INSTANCE.register(IStatus::class.java, StatusStorage(), Callable { Status() })

		MinecraftForge.EVENT_BUS.register(CapabilityHandler())
		MinecraftForge.EVENT_BUS.register(CapabilityCloneEvent())
		MinecraftForge.EVENT_BUS.register(LevelUp())
		MinecraftForge.EVENT_BUS.register(PlayerAttributeEvent())
		MinecraftForge.EVENT_BUS.register(TickEvent())

		//RenderingRegistry.registerEntityRenderingHandler(SkillBullet::class.java, RenderSkillBullet())

		proxy?.init()
	}

	@Mod.EventHandler
	fun postInit(event: FMLPostInitializationEvent?) {
		MinecraftForge.EVENT_BUS.register(RenderMPIndicator())
		proxy?.postInit()
	}

	@SubscribeEvent
	fun registerItem(event: RegistryEvent.Register<Item?>?) {
		for (item in Storage.Items) {
			event?.registry?.register(item)
		}
		event!!.registry.register(ItemBlock(injection_table).setRegistryName(ResourceLocation(ID, "injection_table")))
		event.registry.register(skill_fruit)
		event.registry.register(life_fruit)
	}

	@SubscribeEvent
	fun registerBlock(event: RegistryEvent.Register<Block?>?) {
		event?.registry?.register(injection_table)
	}

	@SubscribeEvent
	fun registerEntities(event: RegistryEvent.Register<EntityEntry>) {
		EntityRegistry.registerModEntity(ResourceLocation("skill_bullet"), SkillBullet::class.java, "skill_bullet", 1, instance, 64, 10, true)
	}

	@SubscribeEvent
	fun registerModel(event: ModelRegistryEvent) {
		proxy?.registerModel()
	}
}