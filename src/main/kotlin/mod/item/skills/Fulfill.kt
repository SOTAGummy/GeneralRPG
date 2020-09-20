package mod.item.skills

import mod.capability.StatusProvider
import mod.item.baseitem.ItemSkill
import mod.enums.SkillRarity
import mod.util.StatusUtil
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumHand
import net.minecraft.world.World

object Fulfill : ItemSkill("fulfill", 0, SkillRarity.MASTER) {
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand, savingRate: Float) {
		if (StatusUtil().useMP(player, this.cost, savingRate)) {
			player.getCapability(StatusProvider.STATUS_CAP!!, null)?.setMp(player.getCapability(StatusProvider.STATUS_CAP, null)?.getMaxMp()!!)
		}
	}
}