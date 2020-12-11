package mod.entity

import net.minecraft.entity.item.EntityItem
import net.minecraft.item.ItemStack
import net.minecraft.world.World

class AnimateItem(world: World, val x: Double, val y: Double, val z: Double, item: ItemStack) :
	EntityItem(world, x, y, z, item) {
	override fun onUpdate() {
		super.onUpdate()
		this.setPosition(x, y, z)
		this.setVelocity(0.0, 0.0, 0.0)
		this.setPickupDelay(1)
		this.hoverStart = 0F
		this.isImmuneToFire = true
	}

	init {
		this.isImmuneToFire = true
		this.alwaysRenderNameTag = true
		this.customNameTag = item.displayName
		this.cannotPickup()
		this.setNoDespawn()
		this.setVelocity(0.0, 0.0, 0.0)
		this.setPosition(x, y, z)
		this.isImmuneToFire = true
		this.hoverStart = 0F
	}

	override fun hasNoGravity(): Boolean {
		return true
	}

	override fun setOnFireFromLava() {

	}

	override fun dealFireDamage(amount: Int) {

	}
}