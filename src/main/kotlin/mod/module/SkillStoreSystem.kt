package mod.module

import mod.item.baseitem.ItemSkill
import net.minecraft.item.ItemStack

var ItemStack.isSkillContainer: Boolean
	get() = false
	set(value){
		this.isSkillContainer = value
	}

val ItemStack.SkillArray: ArrayList<ItemSkill>
	get() = this.SkillArray

var ItemStack.capacity: Int
	get() = this.capacity
	set(value) {
		this.capacity = value
	}

fun ItemStack.isSkillStorable(): Boolean{
	return this.isSkillContainer
}

