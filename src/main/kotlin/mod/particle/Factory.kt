package mod.particle

import net.minecraft.client.particle.IParticleFactory
import net.minecraft.client.particle.Particle
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

@SideOnly(Side.CLIENT)
class Factory: IParticleFactory{
	override fun createParticle(particleID: Int, worldIn: World, xCoordIn: Double, yCoordIn: Double, zCoordIn: Double, xSpeedIn: Double, ySpeedIn: Double, zSpeedIn: Double, vararg p_178902_15_: Int): Particle? {
		val pos = BlockPos(xCoordIn, yCoordIn, zCoordIn)
		return FireParticle(worldIn, pos)
	}
}