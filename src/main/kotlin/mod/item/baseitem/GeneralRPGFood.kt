package mod.item.baseitem

import mod.Core
import mod.enums.ItemRarity
import mod.module.IGeneralRarity
import mod.util.Reference
import mod.util.Storage
import net.minecraft.client.util.ITooltipFlag
import net.minecraft.item.ItemFood
import net.minecraft.item.ItemStack
import net.minecraft.util.ResourceLocation
import net.minecraft.world.World
import java.io.File

open class GeneralRPGFood(amount: Int, saturation: Float, isWolfFood: Boolean, name: String, rarity: ItemRarity) :
	ItemFood(amount, saturation, isWolfFood), IGeneralRarity {
	init {
		this.maxStackSize = 64
		this.unlocalizedName = name
		this.registryName = ResourceLocation(Core.ID, name)
		this.creativeTab = Core.modTab
		Storage.Items.add(this)

		val file = File("D:\\mod\\GeneralRPG\\src\\main\\resources\\assets\\general-rpg\\models\\item\\$name.json")
		if (!file.exists()) {
			file.createNewFile()
			file.writeText(Reference.getJsonText(name))
		}
	}

	override val itemRarity: ItemRarity = rarity

	override fun addInformation(stack: ItemStack, worldIn: World?, tooltip: MutableList<String>, flagIn: ITooltipFlag) {
		indicateRarity(tooltip)
	}
}