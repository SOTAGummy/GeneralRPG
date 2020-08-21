package mod.item.skill.skills

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import mod.item.baseitem.ItemSkill
import mod.item.skill.SkillRarity
import mod.util.StatusUtil
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.projectile.EntityTippedArrow
import net.minecraft.item.ItemBow
import net.minecraft.item.ItemEnderPearl
import net.minecraft.util.EnumHand
import net.minecraft.world.World
import kotlin.random.Random

object ArrowRain: ItemSkill("arrowrain", 20, SkillRarity.RARE){
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
		if (StatusUtil().useMP(player, this.cost)) {
			GlobalScope.launch {
					val pos = player.rayTrace(15.0, 0.0F)?.blockPos!!

					repeat(10){
						val randomx = Random.nextDouble(3.0)
						val randomz = Random.nextDouble(3.0)
						val arrow = EntityTippedArrow(world, pos.x.toDouble() + randomx, pos.y.toDouble() + 5.0, pos.z.toDouble() + randomz)
						arrow.setVelocity(0.0, -1.0, 0.0)
						arrow.damage = 1.0
						arrow.shootingEntity = player
						world.spawnEntity(arrow)
						delay(200)
						world.removeEntity(arrow)
				}
			}
		}
	}
}