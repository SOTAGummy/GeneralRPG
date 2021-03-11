package mod.item.skills

import mod.enums.ItemRarity
import mod.enums.SkillType
import mod.item.baseitem.ItemSkill
import net.minecraft.entity.EntityLiving
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumHand
import net.minecraft.world.World
import kotlin.math.abs

object Blow : ItemSkill("blow", 40.0, ItemRarity.UNCOMMON, SkillType.WIND, false) {
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
		if (!world.isRemote) {
			val entity = arrayListOf<EntityLiving>()
			repeat(world.loadedEntityList.size) {
				if (world.loadedEntityList[it] is EntityLiving && player.getDistance(world.loadedEntityList[it])
						.toInt() <= 10
				) {
					entity.add(world.loadedEntityList[it] as EntityLiving)
				}
			}
			repeat(entity.size) {
				val pos1 = player.position
				val pos2 = entity[it].position

				val xDis = if (pos1.x > pos2.x) {
					-abs(pos1.x - pos2.x)
				} else {
					abs(pos1.x - pos2.x)
				}


				val zDis = if (pos1.z > pos2.z) {
					-abs(pos1.z - pos2.z)
				} else {
					abs(pos1.z - pos2.z)
				}

				val xVel = 1.0 / xDis
				val zVel = 1.0 / zDis

				entity[it].addVelocity(xVel, 0.2, zVel)
			}
		}
	}
}