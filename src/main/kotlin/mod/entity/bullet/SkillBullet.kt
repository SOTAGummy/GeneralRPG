package mod.entity.bullet

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.projectile.EntityThrowable
import net.minecraft.util.math.RayTraceResult
import net.minecraft.world.World

class SkillBullet(world: World, player: EntityPlayer): EntityThrowable(world, player){
	init {

	}

	override fun onImpact(result: RayTraceResult) {

	}
}