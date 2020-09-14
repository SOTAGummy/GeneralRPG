package mod.item.skills

import mod.item.baseitem.ItemSkill
import mod.enums.SkillRarity
import mod.util.StatusUtil
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumHand
import net.minecraft.world.World

object HealP: ItemSkill("heal+", 10, SkillRarity.UNCOMMON){
	override suspend fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
		if (StatusUtil().useMP(player, this.cost)) {
			if (player.maxHealth <= player.health + 4) {
				player.health = player.maxHealth
			} else {
				player.health += 4
			}
		}
	}
}