package mod.item.skills

import mod.enums.ItemRarity
import mod.item.baseitem.ItemSkill
import mod.util.StatusUtil
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumHand
import net.minecraft.world.World

object Heal : ItemSkill("heal", 5.0, ItemRarity.COMMON, false) {
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand, savingRate: Double) {
		if (StatusUtil.useMP(player, this.cost, savingRate)) {
			if (player.maxHealth <= player.health + 2) {
				player.health = player.maxHealth
			} else {
				player.health += 2
			}
		}
	}
}