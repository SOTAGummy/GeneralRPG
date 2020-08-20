package mod.item.skill.skills

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import mod.item.baseitem.ItemSkill
import mod.item.skill.SkillRarity
import mod.util.StatusUtil
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.projectile.EntityTippedArrow
import net.minecraft.util.EnumHand
import net.minecraft.world.World

object ArrowRain: ItemSkill("arrowrain", 20, SkillRarity.RARE){
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
		if (StatusUtil().useMP(player, this.cost)) {
			GlobalScope.launch {
				val pos = player.rayTrace(15.0, 0.0F)?.blockPos!!

				val arrow = EntityTippedArrow(world, pos.x.toDouble(), pos.y.toDouble() + 5.0, pos.z.toDouble())
				arrow.setVelocity(0.0, -2.0, 0.0)
				arrow.damage = 2.0
				arrow.shootingEntity = player
				world.spawnEntity(arrow)
				delay(300)
				world.removeEntity(arrow)

			}
		}
	}
}