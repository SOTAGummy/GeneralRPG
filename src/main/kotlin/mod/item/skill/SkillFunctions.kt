package mod.item.skill

import mod.util.StatusUtil
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumHand
import net.minecraft.world.World

enum class SkillFunctions(val cost: Int) {
	HEAL(5) {
		override fun SkillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
			StatusUtil().useMP(player, HEAL.cost)
			if (player.maxHealth <= player.health + 2) {
				player.health = player.maxHealth
			} else {
				player.health += 2
			}
		}
	},
	FULFILL(0) {
		override fun SkillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
			StatusUtil().addMP(player, 10000000)
		}
	};

	abstract fun SkillFunction(world: World, player: EntityPlayer, handIn: EnumHand)
}