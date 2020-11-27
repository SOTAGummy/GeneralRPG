package mod.module

import mod.enums.ItemRarity

interface IGeneralRarity {
	val itemRarity: ItemRarity

	fun getGeneralRarity(): ItemRarity{
		return itemRarity
	}
}