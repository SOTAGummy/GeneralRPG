package mod.event.bindSkillEvent

import mod.block.TileEntityInjectionTable
import mod.item.baseitem.ItemSkill
import mod.item.items.SkillBook
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.util.EnumHand
import net.minecraftforge.event.entity.player.PlayerInteractEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

class BindSkillEvent {
	@SubscribeEvent
	fun onBindSkillEvent(event: PlayerInteractEvent.RightClickBlock){
		if (event.entityPlayer.getHeldItem(EnumHand.MAIN_HAND).item is ItemSkill && event.world.getBlockState(event.pos).block.unlocalizedName == "tile.injection_table" && (event.world.getTileEntity(event.pos) as TileEntityInjectionTable).getSkill() == 0){
			val te  = event.world.getTileEntity(event.pos) as TileEntityInjectionTable
			val item = event.entityPlayer.getHeldItem(EnumHand.MAIN_HAND).item
			te.setSkill(Item.getIdFromItem(item))
			event.entityPlayer.setHeldItem(EnumHand.MAIN_HAND, ItemStack.EMPTY)
		} else if (event.entityPlayer.getHeldItem(EnumHand.MAIN_HAND).item is SkillBook && event.world.getBlockState(event.pos).block.unlocalizedName == "tile.injection_table" && (event.world.getTileEntity(event.pos) as TileEntityInjectionTable).getSkill() != 0){
			val te  = event.world.getTileEntity(event.pos) as TileEntityInjectionTable
			val item = event.entityPlayer.getHeldItem(EnumHand.MAIN_HAND)
			if (item.tagCompound == null){
				val nbt = NBTTagCompound()
				nbt.setInteger("1", te.getSkill())
				item.tagCompound = nbt
			} else if (item.tagCompound!!.getString("2") == null){
				item.tagCompound!!.setInteger("2", te.getSkill())
			} else if (item.tagCompound!!.getString("3") == null){
				item.tagCompound!!.setInteger("3", te.getSkill())
			} else if (item.tagCompound!!.getString("4") == null){
				item.tagCompound!!.setInteger("4", te.getSkill())
			}
			te.setSkill(0)
		}
	}
}