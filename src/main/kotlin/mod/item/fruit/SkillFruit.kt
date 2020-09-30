package mod.item.fruit

import mod.Core
import mod.capability.StatusProvider
import mod.util.Storage
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemFood
import net.minecraft.item.ItemStack
import net.minecraft.util.ResourceLocation
import net.minecraft.world.World

object SkillFruit : ItemFood(0, 0F, false) {
	init {
		this.maxStackSize = 64
		this.unlocalizedName = "skill_fruit"
		this.registryName = ResourceLocation(Core.ID, "skill_fruit")
		this.setAlwaysEdible()
		this.creativeTab = Core.modTab

		Storage.Items.add(this)
	}

	override fun onFoodEaten(stack: ItemStack, worldIn: World, player: EntityPlayer) {
		player.getCapability(StatusProvider.STATUS_CAP!!, null)?.addMaxMp(2)
		player.getCapability(StatusProvider.STATUS_CAP, null)?.addMp(2)
	}

	override fun getMaxItemUseDuration(stack: ItemStack): Int {
		return 10
	}
}