package mod.item.skill.skills

import mod.item.baseitem.ItemSkill
import mod.item.skill.SkillRarity
import mod.util.StatusUtil
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumHand
import net.minecraft.util.math.MathHelper
import net.minecraft.world.World

object LeapP: ItemSkill("leap+", 35, SkillRarity.LEGEND){
	override suspend fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
		if (StatusUtil().useMP(player, this.cost)) {
			val vx = -MathHelper.sin(Math.toRadians(player.rotationYaw.toDouble()).toFloat()) * MathHelper.cos(Math.toRadians(player.rotationPitch.toDouble()).toFloat())
			val vz = MathHelper.cos(Math.toRadians(player.rotationYaw.toDouble()).toFloat()) * MathHelper.cos(Math.toRadians(player.rotationPitch.toDouble()).toFloat())
			val vy = -MathHelper.sin(Math.toRadians(player.rotationPitch.toDouble()).toFloat())
			player.addVelocity(vx.toDouble() * 1.5, vy.toDouble() * 1.5, vz.toDouble() * 1.5)
		}
	}
}