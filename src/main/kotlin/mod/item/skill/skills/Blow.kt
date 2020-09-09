package mod.item.skill.skills

import mod.item.baseitem.ItemSkill
import mod.item.skill.SkillRarity
import mod.util.StatusUtil
import net.minecraft.entity.monster.EntityMob
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumHand
import net.minecraft.world.World

object Blow: ItemSkill("blow", 40, SkillRarity.UNCOMMON){
	override suspend fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
		if (StatusUtil().useMP(player, this.cost)){
			val entity = arrayListOf<EntityMob>()
			repeat(world.loadedEntityList.size){
				if (world.loadedEntityList[it] is EntityMob && player.getDistance(world.loadedEntityList[it]) <= 10.0){
					entity.add(world.loadedEntityList[it] as EntityMob)
				}
			}

		}
	}
}