package mod.item.skills

import mod.enums.ItemRarity
import mod.item.baseitem.ItemSkill
import mod.util.StatusUtil
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumFacing
import net.minecraft.util.EnumHand
import net.minecraft.world.World

object Light : ItemSkill("light", 5.0, ItemRarity.COMMON) {
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
		val pos = player.rayTrace(15.0, 0.0F)!!.blockPos
		//val down = pos.down()
		//val side1 = pos.north().up()
		//val side2 = pos.east()
		//val side3 = pos.south()
		//val side4 = pos.west()
		val face = EnumFacing.getDirectionFromEntityLiving(pos, player).opposite

		//if(world.getBlockState(pos).block != null && face == EnumFacing.NORTH) {

		//}
		println(face)
	}
}