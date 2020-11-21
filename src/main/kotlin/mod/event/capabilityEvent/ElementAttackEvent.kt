package mod.event.capabilityEvent

import mod.Core
import mod.util.Attributes
import net.minecraft.client.Minecraft
import net.minecraft.entity.EntityLiving
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.player.EntityPlayerMP
import net.minecraft.potion.PotionEffect
import net.minecraftforge.event.entity.living.LivingHurtEvent
import net.minecraftforge.event.entity.player.AttackEntityEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

class ElementAttackEvent {
	@SubscribeEvent
	fun onElementAttack(event: AttackEntityEvent){
		val target = event.target as EntityLiving
		val player = event.entityPlayer
		if (player.getEntityAttribute(Attributes.ELECTRICATTACK).attributeValue >= 1.0){
			target.attackEntityFrom(Core.LightningSource, 0.00001F)
		}
	}

	@SubscribeEvent
	fun onAttackedEvent(event: LivingHurtEvent){
		if (event.entityLiving is EntityPlayerMP){
			val player = event.entityLiving as EntityPlayer
			if (player.getEntityAttribute(Attributes.ELECTRICBODY).attributeValue >= 1.0){
				(event.source.trueSource as EntityLivingBase).addPotionEffect(PotionEffect(Core.electricShockEffect, 30))
			}
		}
	}
}