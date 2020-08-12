package mod.event.bindSkillEvent

import mod.block.TileEntityInjectionTable
import mod.item.baseitem.ItemSkill
import mod.item.items.SkillBook
import net.minecraft.block.Block
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.util.EnumHand
import net.minecraftforge.event.entity.player.PlayerInteractEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

class BindSkillEvent {
	@SubscribeEvent
	fun onBindSkillEvent(event: PlayerInteractEvent.RightClickBlock){
		if (event.entityPlayer.getHeldItem(EnumHand.MAIN_HAND).item is ItemSkill && event.world.getBlockState(event.pos).block == Block.getBlockFromName("injection_table")){
			var te  = event.world.getTileEntity(event.pos) as TileEntityInjectionTable
			var item = event.entityPlayer.getHeldItem(EnumHand.MAIN_HAND).item
			te.setSkill(item.unlocalizedName)
		}else if (event.entityPlayer.getHeldItem(EnumHand.MAIN_HAND).item is SkillBook && event.world.getBlockState(event.pos).block == Block.getBlockFromName("injection_table")){
			var te  = event.world.getTileEntity(event.pos) as TileEntityInjectionTable
			var item = event.entityPlayer.getHeldItem(EnumHand.MAIN_HAND)
			if (item.tagCompound == null){
				var nbt = NBTTagCompound()
				nbt.setString("1", te.getSkill())
				item.tagCompound = nbt
			} else if (item.tagCompound!!.getString("2") == null){
				item.tagCompound!!.setString("2", te.getSkill())
			} else if (item.tagCompound!!.getString("3") == null){
				item.tagCompound!!.setString("3", te.getSkill())
			} else if (item.tagCompound!!.getString("4") == null){
				item.tagCompound!!.setString("4", te.getSkill())
			}
		}
	}
}