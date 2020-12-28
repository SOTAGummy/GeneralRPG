package mod.item.skills

import mod.enums.ItemRarity
import mod.item.baseitem.ItemSkill
import net.minecraft.client.Minecraft
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.EntityEquipmentSlot
import net.minecraft.util.EnumHand
import net.minecraft.world.World

object CodeTest: ItemSkill("codetest", 0.0, ItemRarity.MASTER){
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
		println(EntityEquipmentSlot.values())
	}
}