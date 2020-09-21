package mod.particle

import net.minecraft.client.particle.Particle
import net.minecraft.client.renderer.block.model.BakedQuad
import net.minecraft.client.renderer.texture.TextureAtlasSprite
import net.minecraft.util.EnumParticleTypes
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraftforge.common.util.EnumHelper

class FireParticle(world: World, pos: BlockPos): Particle(world, pos.x.toDouble(), pos.y.toDouble(), pos.z.toDouble()){
	init {
		//EnumHelper.addEnum(EnumParticleTypes::class.java, "FIRE")
	}

	override fun onUpdate() {
		super.onUpdate()
	}
}