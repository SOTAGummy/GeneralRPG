package mod.item.skills

import mod.item.baseitem.ItemSkill
import mod.enums.SkillRarity
import mod.util.StatusUtil
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumHand
import net.minecraft.world.World

object HealP: ItemSkill("heal+", 10, SkillRarity.UNCOMMON, false){
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand, savingRate: Float) {
		if (StatusUtil().useMP(player, this.cost, savingRate)) {
			if (player.maxHealth <= player.health + 4) {
				player.health = player.maxHealth
			} else {
				player.health += 4
			}
		}
	}
}