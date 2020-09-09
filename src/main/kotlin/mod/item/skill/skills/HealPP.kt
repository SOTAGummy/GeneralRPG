package mod.item.skill.skills

import mod.item.baseitem.ItemSkill
import mod.item.skill.SkillRarity
import mod.util.StatusUtil
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumHand
import net.minecraft.world.World

object HealPP: ItemSkill("heal++", 25, SkillRarity.RARE){
	override suspend fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
		if (StatusUtil().useMP(player, this.cost)) {
			if (player.maxHealth <= player.health + 8) {
				player.health = player.maxHealth
			} else {
				player.health += 8
			}
		}
	}
}