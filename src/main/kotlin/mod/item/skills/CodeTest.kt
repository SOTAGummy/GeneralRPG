package mod.item.skills

import mod.capability.MpProvider
import mod.enums.ItemRarity
import mod.enums.SkillType
import mod.item.baseitem.ItemSkill
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumHand
import net.minecraft.world.World

object CodeTest: ItemSkill("codetest", 0.0, ItemRarity.MASTER, SkillType.UTIL){
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
		if (world.isRemote){
			println(player.getCapability(MpProvider.MP!!, null)?.getMp())
			player.getCapability(MpProvider.MP, null)?.useMp(30)
			println(player.getCapability(MpProvider.MP, null)?.getMp())
		}
	}
}