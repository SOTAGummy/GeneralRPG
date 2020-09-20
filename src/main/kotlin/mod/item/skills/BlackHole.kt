package mod.item.skills

import mod.Core
import mod.item.baseitem.ItemSkill
import mod.enums.SkillRarity
import mod.util.StatusUtil
import net.minecraft.entity.EntityLiving
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.DamageSource
import net.minecraft.util.EnumHand
import net.minecraft.world.World

object BlackHole : ItemSkill("blackhole", 50, SkillRarity.RARE) {
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand, savingRate: Float) {
		if (StatusUtil().useMP(player, this.cost, savingRate)){
			val entityList = world.loadedEntityList
			val livingList = arrayListOf<EntityLiving>()
			val pos = player.rayTrace(15.0, 0.0F)!!.blockPos

			repeat(entityList.size) {
				if (entityList[it] is EntityLiving && entityList[it] !is EntityPlayer && entityList[it].getDistanceSq(pos).toInt() <= 15.0) {
					livingList.add(entityList[it] as EntityLiving)
				}
			}

			repeat(livingList.size) {
				livingList[it].setPosition(pos.x.toDouble(), pos.y.toDouble() + 1.0, pos.z.toDouble())
			}
		}
	}
}