package mod.source

import net.minecraft.util.DamageSource

class SkillDamageSource : DamageSource("skill") {
	init {
		this.setDamageIsAbsolute()
	}
}