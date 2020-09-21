package mod.enums

import net.minecraft.util.DamageSource

enum class SkillAttribute(val source: DamageSource){
	FIRE(DamageSource("fire")),
	ICE(DamageSource("ice")),
	WIND(DamageSource("wind")),
	EARTHEN(DamageSource("earthen")),
	LIGHTNING(DamageSource("lightning")),
	WATER(DamageSource("water")),
	LIGHT(DamageSource("light")),
	DARK(DamageSource("dark"))
}