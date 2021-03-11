package mod.util

import mod.enchantment.AccessoryEnchantment
import mod.item.baseitem.ItemSkill
import net.minecraft.entity.SharedMonsterAttributes
import net.minecraft.entity.ai.attributes.IAttribute
import net.minecraft.item.Item
import net.minecraft.potion.Potion
import java.util.*

class Storage {
	companion object {
		val Items: ArrayList<Item> = arrayListOf()
		val Skills: ArrayList<ItemSkill> = arrayListOf()
		val Effects: ArrayList<Potion> = arrayListOf()
		val Instances: ArrayList<Item> = arrayListOf()
		val Attributes: ArrayList<IAttribute> = arrayListOf()
		val Enchantments: ArrayList<AccessoryEnchantment> = arrayListOf()

		val useMPUUID = UUID.fromString("7fa560ab-e973-4939-a89a-43bb160be743")
		val addMPUUID = UUID.fromString("ee6df20b-d103-4a32-8b7d-657fcc01c16a")
	}
}

