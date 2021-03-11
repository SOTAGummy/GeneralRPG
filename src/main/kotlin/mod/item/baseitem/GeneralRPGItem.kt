package mod.item.baseitem

import mod.Core
import mod.enums.ItemRarity
import mod.module.IGeneralRarity
import mod.util.Storage
import net.minecraft.item.Item

open class GeneralRPGItem(rarity: ItemRarity) : Item(), IGeneralRarity {
	init {
		this.creativeTab = Core.modTab
		Storage.Items.add(this)
	}

	override val itemRarity: ItemRarity = rarity
}