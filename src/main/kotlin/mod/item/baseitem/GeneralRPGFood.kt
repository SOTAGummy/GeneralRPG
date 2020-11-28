package mod.item.baseitem

import mod.Core
import mod.enums.ItemRarity
import mod.module.IGeneralRarity
import mod.util.Storage
import net.minecraft.client.resources.I18n
import net.minecraft.client.util.ITooltipFlag
import net.minecraft.item.ItemFood
import net.minecraft.item.ItemStack
import net.minecraft.util.ResourceLocation
import net.minecraft.world.World

open class GeneralRPGFood(amount: Int, saturation: Float, isWolfFood: Boolean, name: String, rarity: ItemRarity): ItemFood(amount, saturation, isWolfFood), IGeneralRarity{
	init {
		this.maxStackSize = 64
		this.unlocalizedName = name
		this.registryName = ResourceLocation(Core.ID, name)
		this.creativeTab = Core.modTab

		Storage.Items.add(this)
	}

	override val itemRarity: ItemRarity = rarity
	override var originalName: String = ""

	override fun addInformation(stack: ItemStack, worldIn: World?, tooltip: MutableList<String>, flagIn: ITooltipFlag) {
		indicateRarity(tooltip)
	}

	override fun getItemStackDisplayName(stack: ItemStack): String {
		originalName = "${getGeneralRarity().colorChar}${I18n.format(super.getItemStackDisplayName(stack))}"
		return indicateDisplayRarity(super.getItemStackDisplayName(stack))
	}
}