package mod.item.skills

import mod.enums.ItemRarity
import mod.enums.SkillType
import mod.item.baseitem.ItemSkill
import mod.pppSystem.IFunctionOperator
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Items
import net.minecraft.item.ItemArrow
import net.minecraft.item.ItemStack
import net.minecraft.util.EnumHand
import net.minecraft.world.World
import kotlin.random.Random

object ArrowRain : ItemSkill("arrowrain", 20.0, ItemRarity.UNCOMMON, SkillType.PHYSICAL) {
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
		val pos = player.rayTrace(15.0, 0.0F)?.blockPos!!
		val itemstack = ItemStack(Items.ARROW)
		val spawn = object : IFunctionOperator {
			override val world: World = world
			override val player: EntityPlayer = player
			override val hand: EnumHand = handIn

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
	}
}
