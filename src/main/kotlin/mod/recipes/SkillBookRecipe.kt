package mod.recipes

import mod.Core
import net.minecraft.inventory.InventoryCrafting
import net.minecraft.item.ItemStack
import net.minecraft.item.crafting.IRecipe
import net.minecraft.world.World

class SkillBookRecipe: IRecipe{
	private val skillbook = ItemStack(Core.skillbook)

	override fun matches(inv: InventoryCrafting, worldIn: World): Boolean {
		var existSkillBook = false
		var extistItemSkill = false
		for (i  in 0..inv.height){
			for (j in 0..inv.width){
				if (){

				}
			}
		}
	}


}