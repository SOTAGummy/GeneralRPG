package mod.item.skills

import mod.item.baseitem.ItemSkill
import mod.enums.SkillRarity
import mod.util.StatusUtil
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumHand
import net.minecraft.world.World

object Heal : ItemSkill("heal", 5, SkillRarity.COMMON) {
	override suspend fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand, savingRate: Float) {
		if (StatusUtil().useMP(player, this.cost, savingRate)) {
			if (player.maxHealth <= player.health + 2) {
				player.health = player.maxHealth
			} else {
				player.health += 2
			}
		}
	}
}