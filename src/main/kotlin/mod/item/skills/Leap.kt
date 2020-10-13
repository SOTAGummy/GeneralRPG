package mod.item.skills

import mod.enums.SkillRarity
import mod.item.baseitem.ItemSkill
import mod.util.StatusUtil
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumHand
import net.minecraft.util.math.MathHelper
import net.minecraft.world.World


object Leap : ItemSkill("leap", 25.0, SkillRarity.EPIC, false) {
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand, savingRate: Double) {
		if (StatusUtil.useMP(player, this.cost, savingRate)) {
			val vx = -MathHelper.sin(Math.toRadians(player.rotationYaw.toDouble()).toFloat()) * MathHelper.cos(Math.toRadians(player.rotationPitch.toDouble()).toFloat())
			val vz = MathHelper.cos(Math.toRadians(player.rotationYaw.toDouble()).toFloat()) * MathHelper.cos(Math.toRadians(player.rotationPitch.toDouble()).toFloat())
			val vy = -MathHelper.sin(Math.toRadians(player.rotationPitch.toDouble()).toFloat())
			player.addVelocity(vx.toDouble(), vy.toDouble(), vz.toDouble())
		}
	}
}