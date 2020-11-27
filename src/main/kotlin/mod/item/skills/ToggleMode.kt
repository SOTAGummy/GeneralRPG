package mod.item.skills

import mod.enums.ItemRarity
import mod.item.baseitem.ItemSkill
import mod.util.StatusUtil
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumHand
import net.minecraft.world.GameType
import net.minecraft.world.World

object ToggleMode : ItemSkill("togglemode", 0.0, ItemRarity.MASTER, false) {
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
		if (StatusUtil.useMP(player, this.cost)) {
			if (player.isCreative) {
				player.setGameType(GameType.SURVIVAL)
			} else {
				player.setGameType(GameType.CREATIVE)
			}
		}
	}
}