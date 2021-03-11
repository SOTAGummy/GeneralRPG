package mod.item.skills

import mod.Core
import mod.enums.ItemRarity
import mod.enums.SkillType
import mod.item.baseitem.ItemSkill
import mod.item.baseitem.ItemSkillContainer
import net.minecraft.client.Minecraft
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumHand
import net.minecraft.world.World
import net.minecraftforge.event.entity.living.LivingHurtEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

object Explosion : ItemSkill("explosion", 30.0, ItemRarity.RARE, SkillType.FIRE, true) {
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
		val pos = player.rayTrace(15.0, 0.0F)?.blockPos!!
		world.createExplosion(player, pos.x.toDouble(), pos.y.toDouble(), pos.z.toDouble(), 3.0F, false)
	}

	@SubscribeEvent
	fun onExplode(event: LivingHurtEvent) {
		if (event.source.damageType == "explosion.player" && Minecraft.getMinecraft().player.getHeldItem(EnumHand.MAIN_HAND).item is ItemSkillContainer) {
			event.entityLiving.attackEntityFrom(Core.FireSource, 50F)
			event.entityLiving.attackEntityFrom(Core.EarthenSource, 5F)
		}
	}
}