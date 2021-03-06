package mod.item.skills

import mod.enums.ItemRarity
import mod.enums.SkillType
import mod.item.baseitem.ItemSkill
import net.minecraft.entity.monster.EntitySlime
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumHand
import net.minecraft.world.World

object SpawnSlimeTest : ItemSkill("spawnslimetest", 0.0, ItemRarity.EXTRA, SkillType.UTIL) {
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
		repeat(7) {
			val slime = EntitySlime(world)
			slime.setPosition(player.posX, player.posY, player.posZ)
			world.spawnEntity(slime)
		}
	}
}