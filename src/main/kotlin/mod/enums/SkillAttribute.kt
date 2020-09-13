package mod.enums

import mod.source.SkillDamageSource

enum class SkillAttribute(val source: SkillDamageSource){
	FIRE(SkillDamageSource("fire")),
	ICE(SkillDamageSource("ice")),
	WIND(SkillDamageSource("wind")),
	EARTHEN(SkillDamageSource("earthen")),
	LIGHTNING(SkillDamageSource("lightning")),
	WATER(SkillDamageSource("water")),
	LIGHT(SkillDamageSource("light")),
	DARK(SkillDamageSource("dark"))
}