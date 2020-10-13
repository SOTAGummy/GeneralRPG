package mod.item.skills

import mod.enums.SkillAttribute
import mod.enums.SkillRarity
import mod.item.baseitem.ItemSkill
import mod.item.baseitem.ItemSkillContainer
import mod.util.StatusUtil
import net.minecraft.client.Minecraft
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumHand
import net.minecraft.world.World
import net.minecraftforge.event.entity.living.LivingHurtEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

object Explosion : ItemSkill("explosion", 30.0, SkillRarity.RARE, true) {
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand, savingRate: Double) {
		if (StatusUtil.useMP(player, this.cost, savingRate)) {
			val pos = player.rayTrace(15.0, 0.0F)?.blockPos!!
			world.createExplosion(player, pos.x.toDouble(), pos.y.toDouble(), pos.z.toDouble(), 3.0F, false)
		}
	}

	@SubscribeEvent
	fun onExplode(event: LivingHurtEvent) {
		if (event.source.damageType == "explosion.player" && Minecraft.getMinecraft().player.getHeldItem(EnumHand.MAIN_HAND).item is ItemSkillContainer) {
			event.entityLiving.attackEntityFrom(SkillAttribute.FIRE.source, 50F)
			event.entityLiving.attackEntityFrom(SkillAttribute.EARTHEN.source, 5F)
		}
	}
}