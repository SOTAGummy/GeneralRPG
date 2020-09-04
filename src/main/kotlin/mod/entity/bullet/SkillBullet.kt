package mod.entity.bullet

import mod.Core
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.projectile.EntityThrowable
import net.minecraft.util.DamageSource
import net.minecraft.util.math.RayTraceResult
import net.minecraft.world.World

class SkillBullet(world: World) : EntityThrowable(world) {
	private var damage = 0.0F

	override fun onImpact(result: RayTraceResult) {
		if (result.entityHit is EntityPlayer) {
			return
		} else if (result.entityHit !is EntityPlayer) {
			setDead()
			//result.entityHit.attackEntityFrom(DamageSource.ANVIL, damage)
		}
	}

	override fun getGravityVelocity(): Float {
		return 0.0F
	}

	override fun onUpdate() {
		super.onUpdate()
		var count = 0
		count++
		if (count >= 100) {
			setDead()
		}
	}

	fun setDamageAmount(amount: Float){
		this.damage = amount
	}
}