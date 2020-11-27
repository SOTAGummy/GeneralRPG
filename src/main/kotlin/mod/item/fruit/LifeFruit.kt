package mod.item.fruit

import mod.item.baseitem.GeneralRPGFood
import net.minecraft.entity.SharedMonsterAttributes
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.world.World

object LifeFruit : GeneralRPGFood(0, 0F, false, "life_fruit") {
	init {
		this.setAlwaysEdible()
	}

	override fun onFoodEaten(stack: ItemStack, worldIn: World, player: EntityPlayer) {
		player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).baseValue += 2
	}

	override fun getMaxItemUseDuration(stack: ItemStack): Int {
		return 10
	}
}