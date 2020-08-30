package mod.item.skill.skills

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import mod.item.baseitem.ItemSkill
import mod.item.skill.SkillRarity
import net.minecraft.entity.EntityLiving
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumHand
import net.minecraft.util.math.Vec3d
import net.minecraft.world.World

object Hole: ItemSkill("hole", 50, SkillRarity.LEGEND){
	override suspend fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
		val entityList = world.loadedEntityList
		val livingList = arrayListOf<EntityLiving>()
		val pos = player.rayTrace(15.0, 0.0F)!!.blockPos
		repeat(entityList.size){
			if (entityList[it] is EntityLiving && entityList[it].getDistanceSq(pos) <= 15){
				livingList.add(entityList[it] as EntityLiving)
			}
		}

		/*GlobalScope.launch {
			repeat(10){
				pos.x - entityList[it].posX

			}
		}*/
	}
}