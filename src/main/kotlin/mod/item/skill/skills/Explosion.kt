package mod.item.skill.skills

import mod.item.baseitem.ItemSkill
import mod.item.skill.SkillRarity
import mod.util.StatusUtil
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumHand
import net.minecraft.world.World

object Explosion: ItemSkill("explosion", 30, SkillRarity.RARE){
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
		if (StatusUtil().useMP(player, this.cost)) {
			val pos = player.rayTrace(15.0, 0.0F)?.blockPos!!
			world.createExplosion(player, pos.x.toDouble(), pos.y.toDouble(), pos.z.toDouble(), 3.0F, false)
		}
	}
}