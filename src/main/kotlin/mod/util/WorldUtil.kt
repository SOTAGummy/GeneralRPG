package mod.util

import net.minecraft.entity.Entity
import net.minecraft.util.math.AxisAlignedBB
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import java.util.*

fun World.getNearEntity(radius: Int, pos: BlockPos): MutableList<Entity> {
	val x = pos.x.toDouble()
	val y = pos.y.toDouble()
	val z = pos.z.toDouble()
	return this.getEntitiesWithinAABB(Entity::class.java, AxisAlignedBB(x, y, z, x + radius, y + radius, z + radius))
}

fun World.getEntityFromUUID(UUID: UUID): Entity?{
	repeat(this.loadedEntityList.size){
		if (this.loadedEntityList[it].uniqueID == UUID){
			return this.loadedEntityList[it]
			return@repeat
		}
	}
	return null
}
