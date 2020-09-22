package mod.util

import mod.item.baseitem.ItemSkill
import net.minecraft.item.Item

class Storage {
	companion object {
		var Items: ArrayList<Item> = arrayListOf()
		var Skills: ArrayList<ItemSkill> = arrayListOf()
		var Instances: ArrayList<ItemSkill> = arrayListOf()
	}
}