package mod.util

import mod.item.baseitem.ItemSkill
import net.minecraft.entity.ai.attributes.IAttribute
import net.minecraft.item.Item
import net.minecraft.potion.Potion

class Storage {
	companion object {
		val Items: ArrayList<Item> = arrayListOf()
		val Skills: ArrayList<ItemSkill> = arrayListOf()
		val Effects: ArrayList<Potion> = arrayListOf()
		val Instances: ArrayList<Item> = arrayListOf()
		val Attributes: ArrayList<IAttribute> = arrayListOf()
	}
}

