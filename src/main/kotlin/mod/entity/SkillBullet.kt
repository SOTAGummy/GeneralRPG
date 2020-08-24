package mod.entity

import net.minecraft.entity.Entity
import net.minecraft.entity.IProjectile
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.world.World

class SkillBullet(worldIn: World) : Entity(worldIn), IProjectile{
	override fun entityInit() {

	}

	override fun shoot(x: Double, y: Double, z: Double, velocity: Float, inaccuracy: Float) {

	}

	override fun readEntityFromNBT(compound: NBTTagCompound) {

	}

	override fun writeEntityToNBT(compound: NBTTagCompound) {

	}
}