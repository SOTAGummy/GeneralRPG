package mod.item.skill.skills

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import mod.item.baseitem.ItemSkill
import mod.enums.SkillRarity
import mod.util.StatusUtil
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Items
import net.minecraft.item.ItemArrow
import net.minecraft.item.ItemStack
import net.minecraft.util.EnumHand
import net.minecraft.world.World
import kotlin.random.Random

object ArrowRain : ItemSkill("arrowrain", 20, SkillRarity.UNCOMMON) {
	override suspend fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
		if (StatusUtil().useMP(player, this.cost)) {
			if (!world.isRemote) {
				val pos = player.rayTrace(15.0, 0.0F)?.blockPos!!
				val itemstack = ItemStack(Items.ARROW)
				repeat(5) {
					val randomx = Random.nextDouble(3.0)
					val randomz = Random.nextDouble(3.0)

					val itemarrow = (if (itemstack.getItem() is ItemArrow) itemstack.getItem() else Items.ARROW) as ItemArrow
					val arrow1 = itemarrow.createArrow(world, itemstack, player)
					arrow1.setPosition(pos.x.toDouble() + randomx, pos.y.toDouble() + 5.0, pos.z.toDouble() + randomz)
					arrow1.damage = 1.0
					arrow1.shootingEntity = player
					arrow1.addVelocity(0.0, -2.0, 0.0)

					world.spawnEntity(arrow1)

					GlobalScope.launch {
						delay(100)
					}.join()
				}
			}
		}
	}
}
