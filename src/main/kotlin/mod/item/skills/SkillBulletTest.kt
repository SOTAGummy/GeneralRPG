package mod.item.skills

import mod.entity.bullet.SkillBullet
import mod.enums.ItemRarity
import mod.item.baseitem.ItemSkill
import mod.util.StatusUtil
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumHand
import net.minecraft.util.math.MathHelper
import net.minecraft.world.World

object SkillBulletTest : ItemSkill("skillbullettest", 0.0, ItemRarity.EXTRA, false) {
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
		if (StatusUtil.useMP(player, this.cost)) {
			val bullet = SkillBullet(world)
			val vx = -MathHelper.sin(Math.toRadians(player.rotationYaw.toDouble()).toFloat()) * MathHelper.cos(Math.toRadians(player.rotationPitch.toDouble()).toFloat()).toDouble()
			val vz = MathHelper.cos(Math.toRadians(player.rotationYaw.toDouble()).toFloat()) * MathHelper.cos(Math.toRadians(player.rotationPitch.toDouble()).toFloat()).toDouble()
			val vy = -MathHelper.sin(Math.toRadians(player.rotationPitch.toDouble()).toFloat()).toDouble()

			world.spawnEntity(bullet)
			bullet.setVelocity(vx, vy, vz)
			bullet.setPosition(player.posX, player.posY, player.posZ)
			bullet.setDamageAmount(10F)
		}
	}
}