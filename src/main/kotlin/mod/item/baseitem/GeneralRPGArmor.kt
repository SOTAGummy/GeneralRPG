package mod.item.baseitem

import mod.Core
import mod.enums.ItemRarity
import mod.util.Storage
import net.minecraft.client.resources.I18n
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.EntityEquipmentSlot
import net.minecraft.item.ItemArmor
import net.minecraft.item.ItemStack
import net.minecraft.util.ResourceLocation
import net.minecraft.world.World
import java.util.*

open class GeneralRPGArmor(name: String, material: ArmorMaterial?, ArmorSlot: EntityEquipmentSlot, rarity: ItemRarity, includeEvents: Boolean = false) : ItemArmor(material!!, 0, ArmorSlot) {
	init {
		this.maxStackSize = 1
		this.unlocalizedName = name
		this.registryName = ResourceLocation(Core.ID, name)
		this.creativeTab = Core.modTab
		Storage.Items.add(this)
		if (includeEvents) Storage.Instances.add(this)
		Rarity = rarity
	}

	companion object {
		var Rarity = ItemRarity.COMMON
		val ARMOR_MODIFIERS = arrayOf(UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"), UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"), UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"), UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150"))
	}

	override fun onArmorTick(world: World, player: EntityPlayer, itemStack: ItemStack) {
		itemStack.itemDamage = 0
	}

	override fun getItemStackDisplayName(stack: ItemStack): String {
		val format = I18n.format(super.getItemStackDisplayName(stack))
		val color = Rarity.colorChar
		return "$color$format"
	}
}