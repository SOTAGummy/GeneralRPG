package mod.item.skills

import mod.item.baseitem.ItemSkill
import mod.enums.SkillRarity
import mod.util.StatusUtil
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumHand
import net.minecraft.world.World

object Explosion : ItemSkill("explosion", 30, SkillRarity.RARE, false) {
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand, savingRate: Float) {
		if (StatusUtil().useMP(player, this.cost, savingRate)) {
			val pos = player.rayTrace(15.0, 0.0F)?.blockPos!!
			world.createExplosion(player, pos.x.toDouble(), pos.y.toDouble(), pos.z.toDouble(), 3.0F, false)
		}
	}
}