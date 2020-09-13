package mod.source

import net.minecraft.util.DamageSource

class SkillDamageSource(name: String): DamageSource(name){
	init {
		this.setDamageIsAbsolute()
	}
}