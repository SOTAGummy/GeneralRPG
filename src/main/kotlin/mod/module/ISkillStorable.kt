package mod.module

import mod.item.baseitem.ItemSkill

interface ISkillStorable {
	var skillArray: ArrayList<ItemSkill>

	fun getSkill(index: Int): ItemSkill? {
		return skillArray[index]
	}

	fun setSkill(index: Int, item: ItemSkill){
		this.skillArray[index] = item
	}

	fun addSkill(item: ItemSkill){
		this.skillArray[this.skillArray.size] = item
	}

	fun clearSkill(){
		this.skillArray = arrayListOf()
	}
}