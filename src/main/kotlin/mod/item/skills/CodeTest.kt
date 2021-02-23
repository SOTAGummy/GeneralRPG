package mod.item.skills

import mod.Core
import mod.enums.ItemRarity
import mod.item.baseitem.ItemSkill
import mod.util.Attributes
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.Item
import net.minecraft.util.EnumHand
import net.minecraft.world.World

object CodeTest: ItemSkill("codetest", 0.0, ItemRarity.MASTER){
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
		if (!world.isRemote){
			player.getEntityAttribute(Attributes.NECKLACE).baseValue = getIdFromItem(Core.power_neckless).toDouble()
		}
	}
}