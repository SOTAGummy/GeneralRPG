package mod.item.skills

import mod.enums.ItemRarity
import mod.item.baseitem.ItemSkill
import mod.pppSystem.PPPSystem
import mod.pppSystem.UniqueBinaryOperator
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
			val pos = player.rayTrace(15.0, 0.0F)?.blockPos!!
			val itemstack = ItemStack(Items.ARROW)
			val spawn = object : UniqueBinaryOperator {
				override val World: World = world
				override val Player: EntityPlayer = player
				override val Hand: EnumHand = handIn

				override fun call(world: World, player: EntityPlayer, hand: EnumHand) {
					val randomX = Random.nextDouble(3.0)
					val randomZ = Random.nextDouble(3.0)
					val itemArrow = (if (itemstack.item is ItemArrow) itemstack.item else Items.ARROW) as ItemArrow
					val arrow = itemArrow.createArrow(world, itemstack, player)
					arrow.setPosition(pos.x.toDouble() + randomX, pos.y.toDouble() + 5.0, pos.z.toDouble() + randomZ)
					arrow.damage = 1.0
					arrow.shootingEntity = player
					arrow.addVelocity(0.0, -2.0, 0.0)
					world.spawnEntity(arrow)
				}
			}

			repeat(5) {
				PPPSystem.insertProcess(spawn)
				PPPSystem.addDelay(2)
			}
		}
	}
}
