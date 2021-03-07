package mod.pppSystem

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumHand
import net.minecraft.world.World

interface IFunctionOperator {
	val world: World
	val player: EntityPlayer
	val hand: EnumHand

	fun call(world: World, player: EntityPlayer, hand: EnumHand)
}