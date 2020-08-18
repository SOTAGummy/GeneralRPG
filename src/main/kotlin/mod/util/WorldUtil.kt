package mod.util

import net.minecraft.entity.Entity
import net.minecraft.util.math.AxisAlignedBB
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class WorldUtil {
	fun getNearEntity(world: World, radius: Int, pos: BlockPos): MutableList<Entity> {
		val x = pos.x.toDouble()
		val y = pos.y.toDouble()
		val z = pos.z.toDouble()
		return world.getEntitiesWithinAABB(Entity::class.java, AxisAlignedBB(x, y, z, x + radius, y + radius, z + radius))
	}
}