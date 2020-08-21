package mod.item.skill.skills

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import mod.item.baseitem.ItemSkill
import mod.item.skill.SkillRarity
import mod.util.StatusUtil
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.projectile.EntityTippedArrow
import net.minecraft.init.Items
import net.minecraft.item.ItemArrow
import net.minecraft.item.ItemStack
import net.minecraft.util.EnumHand
import net.minecraft.world.World
import kotlin.random.Random

object ArrowRain: ItemSkill("arrowrain", 20, SkillRarity.RARE){
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
		if (StatusUtil().useMP(player, this.cost)) {
			GlobalScope.launch {
				val pos = player.rayTrace(15.0, 0.0F)?.blockPos!!
				val itemstack = ItemStack(Items.ARROW)
				repeat(5){
					if (!world.isRemote){
						val randomx = Random.nextDouble(3.0)
						val randomz = Random.nextDouble(3.0)
						val itemarrow = (if (itemstack.getItem() is ItemArrow) itemstack.getItem() else Items.ARROW) as ItemArrow

						val arrow1 = itemarrow.createArrow(world, itemstack, player)
						arrow1.setPosition(pos.x.toDouble() + randomx, pos.y.toDouble() + 5.0, pos.z.toDouble() + randomz)
						arrow1.setVelocity(0.0, -1.0, 0.0)
						arrow1.damage = 1.0
						world.spawnEntity(arrow1)
						delay(50)
						world.removeEntity(arrow1)
					}
				}
			}
		}
	}
}