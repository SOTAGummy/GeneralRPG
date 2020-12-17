package mod.item.skills

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import mod.enums.ItemRarity
import mod.item.baseitem.ItemSkill
import mod.util.StatusUtil
import net.minecraft.entity.SharedMonsterAttributes
import net.minecraft.entity.ai.attributes.AttributeModifier
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumHand
import net.minecraft.world.World
import java.util.*

object Rage : ItemSkill("rage", 10.0, ItemRarity.UNCOMMON, false) {
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
		GlobalScope.launch {
			val uuid = UUID.fromString("42368924-8a13-4409-990c-4e7c6cc57227")
			val mod = AttributeModifier(uuid, "atk", 2.0, 0)
			player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).applyModifier(mod)
			delay(10000)
			player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).removeModifier(mod)
		}
	}
}