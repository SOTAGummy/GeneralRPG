package mod.entity

import net.minecraft.entity.item.EntityItem
import net.minecraft.item.ItemStack
import net.minecraft.world.World

class AnimateItem(world: World, x: Double, y: Double, z: Double, item: ItemStack, val nametag: String): EntityItem(world, x, y, z, item){
	override fun onUpdate() {
		super.onUpdate()
		this.lifespan = this.age + 1
		this.setPickupDelay(1000)
		this.customNameTag = nametag
	}
}