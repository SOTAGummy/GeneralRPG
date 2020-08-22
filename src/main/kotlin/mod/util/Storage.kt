package mod.util

import com.sun.javafx.charts.Legend
import mod.item.baseitem.ItemSkill
import net.minecraft.item.Item
import net.minecraftforge.event.entity.living.LivingHurtEvent

class Storage {
	companion object {
		var Items: ArrayList<Item> = arrayListOf()
		var Skills: ArrayList<ItemSkill> = arrayListOf()
		var Common: ArrayList<ItemSkill> = arrayListOf()
		var Uncommon: ArrayList<ItemSkill> = arrayListOf()
		var Rare: ArrayList<ItemSkill> = arrayListOf()
		var Epic: ArrayList<ItemSkill> = arrayListOf()
		var Legend: ArrayList<ItemSkill> = arrayListOf()
		val Master: ArrayList<ItemSkill> = arrayListOf()
	}
}