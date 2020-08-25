package mod.entity

import net.minecraft.entity.item.EntityItem
import net.minecraft.item.ItemStack
import net.minecraft.world.World

class AnimateItem(world: World, val x: Double, val y: Double, val z: Double, item: ItemStack, val nametag: String): EntityItem(world, x, y, z, item){
	override fun onUpdate() {
		super.onUpdate()
		this.lifespan
		this.customNameTag = nametag
		this.setPosition(x, y, z)
	}

	init {
		this.isImmuneToFire = true
		this.alwaysRenderNameTag = true
		this.isInWeb = true
		this.cannotPickup()
	}
}