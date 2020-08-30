package mod.item.skill.skills

import mod.item.baseitem.ItemSkill
import mod.item.skill.SkillRarity
import mod.util.StatusUtil
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumHand
import net.minecraft.world.World

object Fulfill : ItemSkill("fulfill", 0, SkillRarity.MASTER) {
	override suspend fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
		if (StatusUtil().useMP(player, this.cost)) {
			StatusUtil().addMP(player, StatusUtil().getMaxMP(player))
		}
	}
}