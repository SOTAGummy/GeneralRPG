package mod.item.skill.skills

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import mod.item.baseitem.ItemSkill
import mod.item.skill.SkillRarity
import mod.util.StatusUtil
import net.minecraft.entity.SharedMonsterAttributes
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumHand
import net.minecraft.world.World
import javax.xml.bind.JAXBElement

object Shield: ItemSkill("shield", 15, SkillRarity.RARE){
	override fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand){
		if (StatusUtil().useMP(player, this.cost)){
			GlobalScope.launch {
				player.getEntityAttribute(SharedMonsterAttributes.ARMOR).baseValue += 2
				delay(10000)
				player.getEntityAttribute(SharedMonsterAttributes.ARMOR).baseValue -= 2
				player.addVelocity(player.pitchYaw.x.toDouble(), player.pitchYaw.y.toDouble(), 0.1)
			}
		}
	}
}