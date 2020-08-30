package mod.item.skill.skills

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import mod.item.baseitem.ItemSkill
import mod.item.skill.SkillRarity
import net.minecraft.entity.EntityLiving
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumHand
import net.minecraft.world.World
import kotlin.math.abs

object BlackHole : ItemSkill("blackhole", 50, SkillRarity.LEGEND) {
	override suspend fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
		val entityList = world.loadedEntityList
		val livingList = arrayListOf<EntityLiving>()
		val pos = player.rayTrace(15.0, 0.0F)!!.blockPos

		repeat(entityList.size) {
			if (entityList[it] is EntityLiving && entityList[it].getDistanceSq(pos) <= 15) {
				livingList.add(entityList[it] as EntityLiving)
			}
		}

		GlobalScope.launch {
			repeat(10) {
				repeat(livingList.size) {
					val disX = abs(pos.x - livingList[it].posX)
					val disY = abs(pos.y - livingList[it].posY)
					val disZ = abs(pos.z - livingList[it].posZ)

					entityList[it].addVelocity(disX, disY, disZ)
					delay(10)
				}
			}
		}
	}
}