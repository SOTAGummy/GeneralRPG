package mod.item.skill.skills

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

object Rage : ItemSkill("rage", 10, SkillRarity.UNCOMMON) {
	override suspend fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
		if (StatusUtil().useMP(player, this.cost)) {
			GlobalScope.launch {
				player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).baseValue += 2
				delay(10000)
				player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).baseValue -= 2
			}
		}
	}
}