package mod.recipes

import mod.Core
import mod.item.baseitem.GeneralRPGItem
import mod.item.baseitem.ItemSkill
import net.minecraft.inventory.InventoryCrafting
import net.minecraft.item.ItemStack
import net.minecraft.item.crafting.IRecipe
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.world.World

abstract class SkillBookRecipe: IRecipe {
	private val skillbook = ItemStack(Core.skillbook)

	override fun matches(inv: InventoryCrafting, worldIn: World): Boolean {
		var existSkillBook = false
		var extistItemSkill = false
		var extistOther = false
		for (i in 0..inv.height) {
			for (j in 0..inv.width) {
				val current = inv.getStackInRowAndColumn(i, j)
				if (current.item is GeneralRPGItem && current.item == skillbook.item && current.tagCompound?.getString("4") == null) {
					existSkillBook = true
					continue
				} else if (current.item is ItemSkill) {
					extistItemSkill = true
					continue
				} else {
					extistOther = true
					continue
				}
			}
		}
		return false
	}
}