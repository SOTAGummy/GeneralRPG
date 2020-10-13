package mod.item.skills

import mod.enums.SkillRarity
import mod.item.baseitem.ItemSkill
import mod.util.Attributes
import mod.util.StatusUtil
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumHand
import net.minecraft.world.World

object Fulfill : ItemSkill("fulfill", 0.0, SkillRarity.MASTER, false) {
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand, savingRate: Double) {
		if (StatusUtil.useMP(player, this.cost, savingRate)) {
			val amount = player.getEntityAttribute(Attributes.MAXMP).attributeValue - player.getEntityAttribute(Attributes.MP).attributeValue
			StatusUtil.addAttributeValue(player, Attributes.MP, amount)
		}
	}
}