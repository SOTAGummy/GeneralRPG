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

object Shield : ItemSkill("shield", 15.0, ItemRarity.RARE, false) {
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
		if (StatusUtil.useMP(player, this.cost)) {
			GlobalScope.launch {
				val uuid = UUID.fromString("55453023-7166-4cd7-970a-9c12803b53c3")
				val mod = AttributeModifier(uuid, "def", 2.0, 0)
				player.getEntityAttribute(SharedMonsterAttributes.ARMOR).applyModifier(mod)
				delay(10000)
				player.getEntityAttribute(SharedMonsterAttributes.ARMOR).removeModifier(mod)
			}
		}
	}
}