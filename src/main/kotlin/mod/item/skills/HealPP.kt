package mod.item.skills

import mod.enums.ItemRarity
import mod.enums.SkillType
import mod.item.baseitem.ItemSkill
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumHand
import net.minecraft.world.World

object HealPP : ItemSkill("heal++", 25.0, ItemRarity.RARE, SkillType.UTIL) {
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
		if (player.maxHealth <= player.health + 8) {
			player.health = player.maxHealth
		} else {
			player.health += 8
		}
	}
}