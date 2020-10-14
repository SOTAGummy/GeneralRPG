package mod.event.capabilityEvent

import mod.util.Attributes
import mod.util.StatusUtil
import net.minecraft.client.Minecraft
import net.minecraft.entity.ai.attributes.AttributeModifier
import net.minecraftforge.event.entity.living.LivingDeathEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import java.util.*

class LevelUp {
	@SubscribeEvent
	fun onDeathEvent(event: LivingDeathEvent) {
		val source = event.source
		val player = Minecraft.getMinecraft().player
		val type = source.damageType
		val flag1 = type == "player" || type == "explosion.player"
		val flag2 = type == "fire" || type == "ice" || type == "wind" || type == "earthen"
		val flag3 = type == "lightning" || type == "water" || type == "light" || type == "dark"
		if (flag1 || flag2 || flag3) {
			val mod = AttributeModifier(UUID.randomUUID(), "exp", event.entityLiving.maxHealth.toDouble() / 2, 0)
			player.getEntityAttribute(Attributes.EXP).applyModifier(mod)
		}
		StatusUtil.canLevelUp(player)
		println(type)
	}
}