package mod

import mod.block.InjectionTable
import mod.block.TileEntityInjectionTable
import mod.capability.accessory.Accessory
import mod.capability.accessory.AccessoryStorage
import mod.capability.accessory.IAccessory
import mod.capability.mp.IMp
import mod.capability.mp.Mp
import mod.capability.mp.MpStorage
import mod.enchantment.TestEnchantment
import mod.event.capabilityEvent.CapabilityEvent
import mod.event.entityEvent.PlayerEvents
import mod.gui.RenderHandler
import mod.gui.accessory.GuiAccessoryHandler
import mod.item.SkillDust
import mod.item.accessory.PowerNeckless
import mod.item.armor.electric_armor.ElectricBoots
import mod.item.armor.electric_armor.ElectricChestplate
import mod.item.armor.electric_armor.ElectricHelmet
import mod.item.armor.electric_armor.ElectricLeggings
import mod.item.armor.strong_armor.StrongBoots
import mod.item.armor.strong_armor.StrongChestplate
import mod.item.armor.strong_armor.StrongHelmet
import mod.item.armor.strong_armor.StrongLeggings
import mod.item.armor.wizard_armor.WizardBoots
import mod.item.armor.wizard_armor.WizardChestplate
import mod.item.armor.wizard_armor.WizardHelmet
import mod.item.armor.wizard_armor.WizardLeggings
import mod.item.baseitem.ItemAccessory
import mod.item.containers.*
import mod.item.fruit.LifeFruit
import mod.item.fruit.SkillFruit
import mod.item.skills.*
import mod.item.tokens.*
import mod.packet.PacketHandler
import mod.potionEffect.*
import mod.proxy.CommonProxy
import mod.tab.GeneralAccessoryTab
import mod.tab.GeneralEnchantmentTab
import mod.tab.GeneralRPGSkillTab
import mod.tab.GeneralRPGTab
import mod.util.Attributes
import mod.util.SlotExtension
import mod.util.Storage
import net.minecraft.block.Block
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.enchantment.Enchantment
import net.minecraft.item.Item
import net.minecraft.item.ItemBlock
import net.minecraft.potion.Potion
import net.minecraft.util.DamageSource
import net.minecraft.util.ResourceLocation
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.common.capabilities.CapabilityManager
import net.minecraftforge.common.util.EnumHelper
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.SidedProxy
import net.minecraftforge.fml.common.event.FMLConstructionEvent
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.network.NetworkRegistry
import net.minecraftforge.fml.common.registry.EntityEntry
import net.minecraftforge.fml.common.registry.GameRegistry

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

		//EnumExtension
		val accessory = SlotExtension.addSlotType("ACCESSORY", 2)
		val necklace = SlotExtension.addEquipmentSlot("NECKLACE", 6, accessory, 0, 1, "necklace")
		val amulet = SlotExtension.addEquipmentSlot("AMULET", 7, accessory, 1, 2, "amulet")
		val glove = SlotExtension.addEquipmentSlot("GLOVE", 8, accessory, 2, 3, "glove")
		val gem = SlotExtension.addEquipmentSlot("GEM", 9, accessory, 3, 4, "gem")

		val accessoryType = EnumHelper.addEnchantmentType("ACCESSORY") { item: Item? -> item is ItemAccessory }!!

		//CreativeTabs
		val modTab: CreativeTabs = GeneralRPGTab()
		val skillTab: CreativeTabs = GeneralRPGSkillTab()
		val accessoryTab: CreativeTabs = GeneralAccessoryTab()
		val enchantmentTab: CreativeTabs = GeneralEnchantmentTab()

		//Items
		val skill_dust = SkillDust

		//ItemSkills
		val heal = Heal
		val heal_P = HealP
		val heal_PP = HealPP
		val rage = Rage
		val shield = Shield
		val leap = Leap
		val leap_P = LeapP
		val leap_PP = LeapPP
		val explosion = Explosion
		val arrow_rain = ArrowRain
		val toggle_mode = ToggleMode
		val fulfill = Fulfill
		val light = Light
		val blackhole = BlackHole
		val blow = Blow
		val spawn_slime_test = SpawnSlimeTest
		val code_test = CodeTest

		//Tokens
		val common_token = CommonToken
		val uncommon_token = UncommonToken
		val rare_token = RareToken
		val epic_token = EpicToken
		val legend_token = LegendToken

		//SkillContainers
		val skill_book = SkillBook
		val skill_staff = SkillStaff
		val skill_orb = SkillOrb
		val ender_dragon_artifact = EnderDragonArtifact
		val wither_artifact = WitherArtifact

		//Foods
		val skill_fruit = SkillFruit
		val life_fruit = LifeFruit

		//Armors
		val strong_helmet = StrongHelmet
		val strong_chestplate = StrongChestplate
		val strong_leggins = StrongLeggings
		val strong_boots = StrongBoots
		val wizard_helmet = WizardHelmet
		val wizard_chestplate = WizardChestplate
		val wizard_leggins = WizardLeggings
		val wizard_boots = WizardBoots
		val electric_helmet = ElectricHelmet
		val electric_chestplate = ElectricChestplate
		val electric_leggins = ElectricLeggings
		val electric_boots = ElectricBoots

		//Accessories
		val power_neckless = PowerNeckless

		//Blocks
		val injection_table = InjectionTable()

		//DamageSources
		val FireSource = DamageSource("fire")
		val IceSource = DamageSource("ice")
		val WindSource = DamageSource("wind")
		val EarthenSource = DamageSource("earthen")
		val LightningSource = DamageSource("lightning")
		val WaterSource = DamageSource("water")
		val LightSource = DamageSource("light")
		val DarkSource = DamageSource("light")

		//PotionEffects
		val burnEffect = BurningEffect()
		val frozenEffect = FrozenEffect()
		val paralysisEffect = ParalysisEffect()
		val muddyEffect = MuddyEffect()
		val electricShockEffect = ElectricShockEffect()
		val floodedEffect = FloodedEffect()

		//Enchantments
		val testEnchantment = TestEnchantment

		//Attributes
		val MAXMP = Attributes.addAttribute("maxmp", 100.0, 100.0, Double.MAX_VALUE)
		val EXP = Attributes.addAttribute("exp", 0.0, 0.0, Double.MAX_VALUE)
		val LEVEL = Attributes.addAttribute("level", 1.0, 1.0, Double.MAX_VALUE)
		val SAVINGRATE = Attributes.addAttribute("savingrate", 0.0, 0.0, 80.0)
		val MPRECOVERRATE = Attributes.addAttribute("mprecoverrate", 2.0, 2.0, Double.MAX_VALUE)
		val ELECTRICATTACK = Attributes.addAttribute("electricattack", 0.0, 0.0, 1.0)
		val ELECTRICBODY = Attributes.addAttribute("electricbody", 0.0, 0.0, 1.0)
	}

	@Mod.EventHandler
	fun construct(event: FMLConstructionEvent?) {
		MinecraftForge.EVENT_BUS.register(this)
		MinecraftForge.EVENT_BUS.register(proxy)
		MinecraftForge.EVENT_BUS.register(CapabilityEvent())
		MinecraftForge.EVENT_BUS.register(PlayerEvents())
		for (item in Storage.Instances) {
			MinecraftForge.EVENT_BUS.register(item)

		}
	}

	@Mod.EventHandler
	fun preInit(event: FMLPreInitializationEvent?) {
		proxy.preInit()
		if (event?.side?.isClient!!) {
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(injection_table), 0, ModelResourceLocation(ResourceLocation(ID, "injection_table"), "inventory"))
		}
		GameRegistry.registerTileEntity(TileEntityInjectionTable::class.java, ResourceLocation(ID, "injection_table"))
		mod.util.registerModel(StrongHelmet, 0)
		NetworkRegistry.INSTANCE.registerGuiHandler(this, GuiAccessoryHandler())
		CapabilityManager.INSTANCE.register(IMp::class.java, MpStorage()) { Mp() }
		CapabilityManager.INSTANCE.register(IAccessory::class.java, AccessoryStorage()) { Accessory() }
		PacketHandler.register()
	}

	@Mod.EventHandler
	fun init(event: FMLInitializationEvent?) {
		//RenderingRegistry.registerEntityRenderingHandler(SkillBullet::class.java, RenderSkillBullet())

		proxy.init()
	}

	@Mod.EventHandler
	fun postInit(event: FMLPostInitializationEvent?) {
		MinecraftForge.EVENT_BUS.register(RenderHandler())
		proxy.postInit()
	}

	@SubscribeEvent
	fun registerItems(event: RegistryEvent.Register<Item?>?) {
		for (item in Storage.Items) {
			event?.registry?.register(item)
		}
		event!!.registry.register(ItemBlock(injection_table).setRegistryName(ResourceLocation(ID, "injection_table")))
		event.registry.register(skill_fruit)
		event.registry.register(life_fruit)
	}

	@SubscribeEvent
	fun registerBlocks(event: RegistryEvent.Register<Block?>?) {
		event?.registry?.register(injection_table)
	}

	@SubscribeEvent
	fun registerEntities(event: RegistryEvent.Register<EntityEntry>) {

	}

	@SubscribeEvent
	fun registerPotionEffects(event: RegistryEvent.Register<Potion>) {
		repeat(Storage.Effects.size) {
			event.registry.register(Storage.Effects[it])
		}
	}

	@SubscribeEvent
	fun registerEnchantments(event: RegistryEvent.Register<Enchantment>) {
		repeat(Storage.Enchantments.size) {
			event.registry.register(Storage.Enchantments[it])
		}
	}

	@SubscribeEvent
	fun registerModel(event: ModelRegistryEvent) {
		proxy.registerModel()
	}
}