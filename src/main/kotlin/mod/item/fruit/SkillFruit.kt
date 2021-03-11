package mod.item.fruit

import mod.Core
import mod.capability.mp.MpProvider
import mod.enums.ItemRarity
import mod.item.baseitem.GeneralRPGFood
import net.minecraft.entity.ai.attributes.AttributeModifier
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.world.World
import java.util.*

object SkillFruit : GeneralRPGFood(0, 0F, false, "skill_fruit", ItemRarity.RARE) {
	init {
		this.setAlwaysEdible()
	}

	override fun onFoodEaten(stack: ItemStack, worldIn: World, player: EntityPlayer) {
		val addMaxMP = AttributeModifier(UUID.randomUUID(), "maxmp", 2.0, 0)

		player.getEntityAttribute(Core.MAXMP).applyModifier(addMaxMP)
		player.getCapability(MpProvider.MP!!, null)?.addMp(player, 2)
	}

	override fun getMaxItemUseDuration(stack: ItemStack): Int {
		return 10
	}
}