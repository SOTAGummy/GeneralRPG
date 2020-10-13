package mod.item.fruit

import mod.Core
import mod.util.Attributes
import mod.util.Storage
import net.minecraft.entity.ai.attributes.AttributeModifier
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemFood
import net.minecraft.item.ItemStack
import net.minecraft.util.ResourceLocation
import net.minecraft.world.World
import java.util.*

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
		val addMaxMP = AttributeModifier(UUID.randomUUID(), "maxmp", 2.0, 0)
		val addMP = AttributeModifier(UUID.randomUUID(), "mp", 2.0, 0)

		player.getEntityAttribute(Attributes.MAXMP).applyModifier(addMaxMP)
		player.getEntityAttribute(Attributes.MP).applyModifier(addMP)
	}

	override fun getMaxItemUseDuration(stack: ItemStack): Int {
		return 10
	}
}