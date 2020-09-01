package mod.item.skill.skills

import mod.item.baseitem.ItemSkill
import mod.item.skill.SkillRarity
import net.minecraft.entity.EntityLiving
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumHand
import net.minecraft.world.World

object BlackHole : ItemSkill("blackhole", 50, SkillRarity.RARE) {
	override suspend fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
		val entityList = world.loadedEntityList
		val livingList = arrayListOf<EntityLiving>()
		val pos = player.rayTrace(15.0, 0.0F)!!.blockPos

		repeat(entityList.size) {
			if (entityList[it] is EntityLiving && entityList[it] !is EntityPlayer && entityList[it].getDistanceSq(pos).toInt() <= 15.0) {
				livingList.add(entityList[it] as EntityLiving)
				println(entityList[it].getDistanceSq(pos))
			}
		}

		repeat(livingList.size){
			livingList[it].setPosition(pos.x.toDouble(), pos.y.toDouble() + 1.0, pos.z.toDouble())
		}
	}
}