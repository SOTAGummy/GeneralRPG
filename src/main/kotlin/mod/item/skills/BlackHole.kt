package mod.item.skills

import mod.enums.ItemRarity
import mod.enums.SkillType
import mod.item.baseitem.ItemSkill
import net.minecraft.entity.EntityLiving
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumHand
import net.minecraft.util.EnumParticleTypes
import net.minecraft.world.World

object BlackHole : ItemSkill("blackhole", 50.0, ItemRarity.LEGEND, SkillType.DARK) {
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
		val entityList = world.loadedEntityList
		val livingList = arrayListOf<EntityLiving>()
		val pos = player.rayTrace(15.0, 0.0F)!!.blockPos
		repeat(10) {
			world.spawnParticle(
				EnumParticleTypes.SPELL_WITCH,
				pos.x.toDouble(),
				pos.y.toDouble(),
				pos.z.toDouble(),
				0.0,
				0.5,
				0.0
			)
		}

		repeat(entityList.size) {
			if (entityList[it] is EntityLiving && entityList[it] !is EntityPlayer && entityList[it].getDistanceSq(pos)
					.toInt() <= 15.0
			) {
				livingList.add(entityList[it] as EntityLiving)
			}
		}

		repeat(livingList.size) {
			livingList[it].setPosition(pos.x.toDouble(), pos.y.toDouble() + 1.0, pos.z.toDouble())
		}
	}
}
