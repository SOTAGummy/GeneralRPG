package mod.item.skill.skills

import mod.item.baseitem.ItemSkill
import mod.item.skill.SkillRarity
import mod.util.StatusUtil
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumHand
import net.minecraft.world.World

object Leap: ItemSkill("leap", 0, SkillRarity.EPIC){
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
		if (StatusUtil().useMP(player, this.cost)) {
			player.addVelocity(player.pitchYaw.x.toDouble() / 100, -player.pitchYaw.y.toDouble(), 1.0)
		}
	}
}