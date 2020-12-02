package mod.item.fruit

import mod.enums.ItemRarity
import mod.item.baseitem.GeneralRPGFood
import mod.util.Attributes
import net.minecraft.entity.ai.attributes.AttributeModifier
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.world.World
import java.util.*

object SkillFruit: GeneralRPGFood(0, 0F, false, "skill_fruit", ItemRarity.RARE){
	init {
		this.setAlwaysEdible()
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