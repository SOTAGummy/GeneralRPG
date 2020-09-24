package mod.item.skills

import mod.item.baseitem.ItemSkill
import mod.enums.SkillRarity
import mod.util.StatusUtil
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumHand
import net.minecraft.world.GameType
import net.minecraft.world.World

object ToggleMode : ItemSkill("togglemode", 0, SkillRarity.MASTER, false) {
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand, savingRate: Float) {
		if (StatusUtil().useMP(player, this.cost, savingRate)) {
			if (player.isCreative) {
				player.setGameType(GameType.SURVIVAL)
			} else {
				player.setGameType(GameType.CREATIVE)
			}
		}
	}
}