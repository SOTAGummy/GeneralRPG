package mod.pppSystem

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumHand
import net.minecraft.world.World

interface UniqueBinaryOperator {
	val World: World
	val Player: EntityPlayer
	val Hand: EnumHand

	fun call(world: World, player: EntityPlayer, hand: EnumHand)
}