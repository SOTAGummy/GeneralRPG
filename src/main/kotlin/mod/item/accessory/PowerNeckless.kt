package mod.item.accessory

import com.google.common.collect.Multimap
import mod.Core
import mod.enums.ItemRarity
import mod.item.baseitem.ItemAccessory
import net.minecraft.enchantment.Enchantment
import net.minecraft.entity.SharedMonsterAttributes
import net.minecraft.entity.ai.attributes.AttributeMap
import net.minecraft.entity.ai.attributes.AttributeModifier
import net.minecraft.entity.ai.attributes.RangedAttribute
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.EntityEquipmentSlot
import net.minecraft.item.ItemStack
import net.minecraft.util.ActionResult
import net.minecraft.util.EnumHand
import net.minecraft.world.World
import java.util.*

object PowerNeckless : ItemAccessory("power_neckless", Core.necklace, ItemRarity.UNCOMMON) {
	override fun getAttributeModifiers(slot: EntityEquipmentSlot, stack: ItemStack): Multimap<String, AttributeModifier> {
		val multimap = super.getAttributeModifiers(slot, stack)
		if (slot == Core.necklace) {
			multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.name, AttributeModifier(getUUID(slot), "atk", 2.0, 0))
			multimap.put(Core.MAXMP.name, AttributeModifier(getUUID(slot), "maxmp", 100.0, 0))
		}
		return multimap
	}
}