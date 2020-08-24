package mod.item.skill.skills

import mod.item.baseitem.ItemSkill
import mod.item.skill.SkillRarity
import mod.util.StatusUtil
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Blocks
import net.minecraft.util.EnumHand
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

object Light: ItemSkill("light", 5, SkillRarity.COMMON){
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand, saveRate: Int) {
		if (StatusUtil().useMP(player, this.cost, saveRate)){
			val pos = player.rayTrace(15.0, 0.0F)!!.blockPos
			val down = BlockPos(pos.x, pos.y - 1, pos.z)
			val side1 = BlockPos(pos.x + 1, pos.y, pos.z)
			val side2 = BlockPos(pos.x - 1, pos.y, pos.z)
			val side3 = BlockPos(pos.x, pos.y, pos.z + 1)
			val side4 = BlockPos(pos.x, pos.y, pos.z - 1)

			if (world.getBlockState(pos).block != null && world.getBlockState(down).isFullBlock || world.getBlockState(side1).isFullBlock || world.getBlockState(side2).isFullBlock || world.getBlockState(side3).isFullBlock || world.getBlockState(side4).isFullBlock){
				world.setBlockState(pos, Blocks.TORCH.defaultState)

			}
		}
	}
}