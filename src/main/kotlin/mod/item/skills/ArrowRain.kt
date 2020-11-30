package mod.item.skills

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import mod.enums.ItemRarity
import mod.item.baseitem.ItemSkill
import mod.util.StatusUtil
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Items
import net.minecraft.item.ItemArrow
import net.minecraft.item.ItemStack
import net.minecraft.util.EnumHand
import net.minecraft.world.World
import kotlin.random.Random

object ArrowRain : ItemSkill("arrowrain", 20.0, ItemRarity.UNCOMMON, false) {
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
		if (StatusUtil.useMP(player, this.cost)) {
			if (!world.isRemote) {
				val pos = player.rayTrace(15.0, 0.0F)?.blockPos!!
				val itemstack = ItemStack(Items.ARROW)
				repeat(5) {
					val randomX = Random.nextDouble(3.0)
					val randomZ = Random.nextDouble(3.0)

					val itemArrow = (if (itemstack.item is ItemArrow) itemstack.item else Items.ARROW) as ItemArrow
					val arrow = itemArrow.createArrow(world, itemstack, player)
					arrow.setPosition(pos.x.toDouble() + randomX, pos.y.toDouble() + 5.0, pos.z.toDouble() + randomZ)
					arrow.damage = 1.0
					arrow.shootingEntity = player
					arrow.addVelocity(0.0, -2.0, 0.0)

					runBlocking {
						world.spawnEntity(arrow)
					}

					GlobalScope.launch {
						GlobalScope.launch {
							delay(100)
							world.removeEntity(arrow)
						}.join()
					}
				}
			}
		}
	}
}
