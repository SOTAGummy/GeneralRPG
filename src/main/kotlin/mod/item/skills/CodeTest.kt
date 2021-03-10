package mod.item.skills

import mod.capability.MpProvider
import mod.enums.ItemRarity
import mod.enums.SkillType
import mod.item.baseitem.ItemSkill
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.ActionResult
import net.minecraft.util.EnumHand
import net.minecraft.world.World

object CodeTest: ItemSkill("codetest", 0.0, ItemRarity.MASTER, SkillType.UTIL){
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
		player.getCapability(MpProvider.MP!!, null)?.useMp(10)
		player.experienceLevel = 1000
	}

	override fun onItemRightClick(world: World, player: EntityPlayer, hand: EnumHand): ActionResult<ItemStack> {
		return super.onItemRightClick(world, player, hand)
	}
}