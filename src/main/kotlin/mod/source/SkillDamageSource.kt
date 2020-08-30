package mod.source

import net.minecraft.entity.Entity
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.DamageSource

class SkillDamageSource(val player: EntityPlayer) : DamageSource("skill") {
	init {
		this.setDamageIsAbsolute()
	}

	override fun getTrueSource(): Entity? {
		return player
	}
}