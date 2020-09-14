package mod.item.fruit

import mod.Core
import mod.util.Storage
import net.minecraft.entity.SharedMonsterAttributes
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemFood
import net.minecraft.item.ItemStack
import net.minecraft.util.ResourceLocation
import net.minecraft.world.World

object LifeFruit: ItemFood(0, 0F, false){
	init {
		this.maxStackSize = 64
		this.unlocalizedName = "life_fruit"
		this.registryName = ResourceLocation(Core.ID, "life_fruit")
		this.setAlwaysEdible()
		this.creativeTab = Core.creativeaTab

		Storage.Items.add(this)
	}

	override fun onFoodEaten(stack: ItemStack, worldIn: World, player: EntityPlayer) {
		player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).baseValue += 2
	}

	override fun getMaxItemUseDuration(stack: ItemStack): Int {
		return 10
	}
}