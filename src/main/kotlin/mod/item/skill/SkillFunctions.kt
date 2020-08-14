package mod.item.skill

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import mod.util.SkillRarity
import mod.util.StatusUtil
import net.minecraft.entity.SharedMonsterAttributes
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumHand
import net.minecraft.world.GameType
import net.minecraft.world.World

enum class SkillFunctions(val cost: Int, val rare: SkillRarity) {
	HEAL(5, SkillRarity.COMMON) {
		override fun SkillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
			if (StatusUtil().useMP(player, this.cost)) {
				if (player.maxHealth <= player.health + 2) {
					player.health = player.maxHealth
				} else {
					player.health += 2
				}
			}
		}
	},
	FULFILL(0, SkillRarity.MASTER) {
		override fun SkillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
			if (StatusUtil().useMP(player, this.cost)) {
				StatusUtil().addMP(player, StatusUtil().getMaxMP(player))
			}
		}
	},
	TOGGLEMODE(0, SkillRarity.MASTER) {
		override fun SkillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
			if (StatusUtil().useMP(player, this.cost)) {
				if (player.isCreative) {
					player.setGameType(GameType.SURVIVAL)
				} else {
					player.setGameType(GameType.CREATIVE)
				}
			}
		}
	},
	RAGE(10, SkillRarity.UNCOMMON) {
		override fun SkillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
			if (StatusUtil().useMP(player, this.cost)) {
				GlobalScope.launch {
					player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).baseValue += 2
					delay(10000)
					player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).baseValue -= 2
				}
			}
		}
	};

	abstract fun SkillFunction(world: World, player: EntityPlayer, handIn: EnumHand)
}