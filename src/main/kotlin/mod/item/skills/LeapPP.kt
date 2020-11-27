package mod.item.skills

import mod.enums.ItemRarity
import mod.item.baseitem.ItemSkill
import mod.util.StatusUtil
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumHand
import net.minecraft.util.math.MathHelper
import net.minecraft.world.World

object LeapPP : ItemSkill("leap++", 50.0, ItemRarity.MYTHIC, false) {
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
		if (StatusUtil.useMP(player, this.cost)) {
			val vx = -MathHelper.sin(Math.toRadians(player.rotationYaw.toDouble()).toFloat()) * MathHelper.cos(Math.toRadians(player.rotationPitch.toDouble()).toFloat())
			val vz = MathHelper.cos(Math.toRadians(player.rotationYaw.toDouble()).toFloat()) * MathHelper.cos(Math.toRadians(player.rotationPitch.toDouble()).toFloat())
			val vy = -MathHelper.sin(Math.toRadians(player.rotationPitch.toDouble()).toFloat())
			player.addVelocity(vx.toDouble() * 2.5, vy.toDouble() * 2.5, vz.toDouble() * 2.5)
		}
	}
}