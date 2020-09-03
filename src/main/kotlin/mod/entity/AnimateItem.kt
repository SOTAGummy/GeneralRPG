package mod.entity

import net.minecraft.entity.item.EntityItem
import net.minecraft.item.ItemStack
import net.minecraft.world.World

class AnimateItem(world: World, val x: Double, val y: Double, val z: Double, item: ItemStack, val nametag: String) : EntityItem(world, x, y, z, item) {
	override fun onUpdate() {
		super.onUpdate()
		this.customNameTag = nametag
		this.setPosition(x, y, z)
		this.setPickupDelay(10)
		this.setVelocity(0.0, 0.0, 0.0)
	}

	init {
		this.isImmuneToFire = true
		this.alwaysRenderNameTag = true
		this.cannotPickup()
		this.setNoDespawn()
	}
}