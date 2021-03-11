package mod.item.skills

import mod.Core
import mod.capability.mp.MpProvider
import mod.enums.ItemRarity
import mod.enums.SkillType
import mod.item.baseitem.ItemSkill
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumHand
import net.minecraft.world.World

object Fulfill : ItemSkill("fulfill", 0.0, ItemRarity.MASTER, SkillType.UTIL) {
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
		player.getCapability(MpProvider.MP!!, null)?.setMp(player.getEntityAttribute(Core.MAXMP).attributeValue.toInt())
	}
}