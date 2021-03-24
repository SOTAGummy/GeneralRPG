package mod.util

import mod.enchantment.AccessoryEnchantment
import mod.item.baseitem.ItemSkill
import net.minecraft.entity.SharedMonsterAttributes
import net.minecraft.entity.ai.attributes.IAttribute
import net.minecraft.item.Item
import net.minecraft.potion.Potion
import java.util.*

object Storage {
	val Items: ArrayList<Item> = arrayListOf()
	val Skills: ArrayList<ItemSkill> = arrayListOf()
	val Effects: ArrayList<Potion> = arrayListOf()
	val Instances: ArrayList<Item> = arrayListOf()
	val Attributes: ArrayList<IAttribute> = arrayListOf()
	val Enchantments: ArrayList<AccessoryEnchantment> = arrayListOf()
}

