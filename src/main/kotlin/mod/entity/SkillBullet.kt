package mod.entity

import net.minecraft.entity.Entity
import net.minecraft.entity.IProjectile
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.MathHelper
import net.minecraft.world.World

class SkillBullet(world: World, Damage: Float, pos: BlockPos, yaw: Float, pitch: Float) : Entity(world), IProjectile {
	val shootingEntity: Entity? = null
	val hittingEntity: Entity? = null
	var damage: Float = 0F
	var speed: Double = 1.0
	val range: Double = 4.0

	init {
		damage = Damage
		this.setLocationAndAngles(pos.x.toDouble(), pos.y.toDouble(), pos.z.toDouble(), yaw, pitch)
		val vx = -MathHelper.sin(Math.toRadians(yaw.toDouble()).toFloat()) * MathHelper.cos(Math.toRadians(pitch.toDouble()).toFloat())
		val vz = MathHelper.cos(Math.toRadians(yaw.toDouble()).toFloat()) * MathHelper.cos(Math.toRadians(pitch.toDouble()).toFloat())
		val vy = -MathHelper.sin(Math.toRadians(pitch.toDouble()).toFloat())
		this.setVelocity(vx.toDouble(), vy.toDouble(), vz.toDouble())
	}

	override fun entityInit() {

	}

	override fun shoot(x: Double, y: Double, z: Double, velocity: Float, inaccuracy: Float) {

	}

	override fun readEntityFromNBT(compound: NBTTagCompound) {

	}

	override fun writeEntityToNBT(compound: NBTTagCompound) {

	}
}