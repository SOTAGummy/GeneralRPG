package mod.item.skills

import mod.enums.ItemRarity
import mod.item.baseitem.ItemSkill
import net.minecraft.entity.monster.EntityMob
import net.minecraft.entity.monster.EntitySlime
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumHand
import net.minecraft.world.World

object CodeTest: ItemSkill("codetest", 0.0, ItemRarity.MASTER){
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {
		repeat(world.loadedEntityList.size){
			if (world.loadedEntityList[it] is EntityMob || world.loadedEntityList[it] is EntitySlime)
			world.loadedEntityList[it].addVelocity(0.0, 0.5, 0.0)
		}
	}
}