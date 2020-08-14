package mod.item.skill

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.Item
import net.minecraft.util.EnumHand
import net.minecraft.world.World
import java.util.*

class SkillFunctionTask(val world: World, val player: EntityPlayer, val handIn: EnumHand): TimerTask(){
	var i = 1
	val itemstack = player.getHeldItem(handIn)
	var name = Item.getItemById(itemstack.tagCompound!!.getInteger(i.toString())).unlocalizedName.split(".")[1]


	override fun run() {
		if (itemstack.tagCompound!!.getInteger(i.toString()) != 0) {
			if (i <= 4) {
				SkillFunctions.valueOf(name.toUpperCase()).SkillFunction(world, player, handIn)
				i++
				name = Item.getItemById(itemstack.tagCompound!!.getInteger(i.toString())).unlocalizedName.split(".")[1]
			}
		}
	}
}