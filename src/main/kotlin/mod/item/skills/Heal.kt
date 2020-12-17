package mod.item.skills

import mod.Core
import mod.enums.ItemRarity
import mod.item.baseitem.ItemSkill
import mod.util.StatusUtil
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.potion.PotionEffect
import net.minecraft.util.EnumHand
import net.minecraft.world.World

object Heal : ItemSkill("heal", 5.0, ItemRarity.COMMON) {
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
		if (player.maxHealth <= player.health + 2) {
			player.health = player.maxHealth
		} else {
			player.health += 2
		}
		player.addPotionEffect(PotionEffect(Core.electricShockEffect, 200000))
	}
}