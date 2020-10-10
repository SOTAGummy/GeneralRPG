package mod.item.skills

import mod.Core
import mod.enums.SkillRarity
import mod.item.baseitem.ItemSkill
import mod.util.StatusUtil
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.potion.PotionEffect
import net.minecraft.util.EnumHand
import net.minecraft.world.World

object Heal : ItemSkill("heal", 5, SkillRarity.COMMON, false) {
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand, savingRate: Float) {
		if (StatusUtil().useMP(player, this.cost, savingRate)) {
			if (player.maxHealth <= player.health + 2) {
				player.health = player.maxHealth
			} else {
				player.health += 2
			}
			player.addPotionEffect(PotionEffect(Core.burnEffect, 2000))
			player.addPotionEffect(PotionEffect(Core.frozenEffect, 2000))
			player.addPotionEffect(PotionEffect(Core.electricShockEffect, 2000))
			player.addPotionEffect(PotionEffect(Core.floodedEffect, 2000))
			player.addPotionEffect(PotionEffect(Core.paralysisEffect, 2000))
			player.addPotionEffect(PotionEffect(Core.muddyEffect, 2000))
		}
	}
}