package mod.util

import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.entity.Entity
import net.minecraft.item.Item
import net.minecraft.util.math.AxisAlignedBB
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraftforge.client.model.ModelLoader
import java.util.*


fun World.getNearEntity(radius: Int, pos: BlockPos): MutableList<Entity> {
	val x = pos.x.toDouble()
	val y = pos.y.toDouble()
	val z = pos.z.toDouble()
	return this.getEntitiesWithinAABB(Entity::class.java, AxisAlignedBB(x, y, z, x + radius, y + radius, z + radius))
}

fun World.getEntityFromUUID(UUID: UUID): Entity? {
	repeat(this.loadedEntityList.size) {
		if (this.loadedEntityList[it].uniqueID == UUID) {
			return this.loadedEntityList[it]
			return@repeat
		}
	}
	return null
}

fun registerModel(item: Item, meta: Int) {
	ModelLoader.setCustomModelResourceLocation(item, meta, ModelResourceLocation(item.registryName, "inventory"))
}

