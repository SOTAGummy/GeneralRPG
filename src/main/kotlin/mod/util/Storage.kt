package mod.util

import mod.item.baseitem.ItemSkill
import net.minecraft.item.Item
import net.minecraftforge.event.entity.living.LivingHurtEvent

class Storage {
	companion object {
		var Items: ArrayList<Item> = arrayListOf()
		var Skills: ArrayList<ItemSkill> = arrayListOf()
	}
}