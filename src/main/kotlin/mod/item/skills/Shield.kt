package mod.item.skills

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import mod.item.baseitem.ItemSkill
import mod.enums.SkillRarity
import mod.util.StatusUtil
import net.minecraft.entity.SharedMonsterAttributes
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumHand
import net.minecraft.world.World

object Shield : ItemSkill("shield", 15, SkillRarity.RARE, false) {
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand, savingRate: Float) {
		if (StatusUtil().useMP(player, this.cost, savingRate)) {
			GlobalScope.launch {
				player.getEntityAttribute(SharedMonsterAttributes.ARMOR).baseValue += 2
				delay(10000)
				player.getEntityAttribute(SharedMonsterAttributes.ARMOR).baseValue -= 2
				player.addVelocity(player.pitchYaw.x.toDouble(), player.pitchYaw.y.toDouble(), 0.1)
			}
		}
	}
}