package mod.util

import mod.item.baseitem.ItemSkill
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.Item
import net.minecraft.network.datasync.DataParameter
import net.minecraft.network.datasync.DataSerializers
import net.minecraft.network.datasync.EntityDataManager
import net.minecraft.potion.Potion

class Storage {
	companion object{
		var Items: ArrayList<Item> = arrayListOf()
		var Skills: ArrayList<ItemSkill> = arrayListOf()
		var Effects: ArrayList<Potion> = arrayListOf()
		var Instances: ArrayList<ItemSkill> = arrayListOf()
	}
}

