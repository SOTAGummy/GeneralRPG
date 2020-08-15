package mod.event.bindSkillEvent

import mod.Core
import mod.block.TileEntityInjectionTable
import mod.item.baseitem.ItemSkill
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.util.EnumHand
import net.minecraftforge.event.entity.player.PlayerInteractEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

class BindSkillEvent {
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	fun onBindSkillEvent(event: PlayerInteractEvent.RightClickBlock) {
		val stack = event.itemStack
		val player = event.entityPlayer
		var te: TileEntityInjectionTable?

		if (event.world.getTileEntity(event.pos) != null && event.world.getTileEntity(event.pos) is TileEntityInjectionTable) {
			te = event.world.getTileEntity(event.pos) as TileEntityInjectionTable
			when (te.getSkill()) {
				0 -> {
					if (stack.item is ItemSkill) {
						te.setSkill(Item.getIdFromItem(stack.item))
						player.setHeldItem(EnumHand.MAIN_HAND, ItemStack.EMPTY)
						println(te.getSkill())
					}
				}

				else -> {
					if (stack.item == Core.skillbook) {
						if (stack.tagCompound == null) {
							val nbt = NBTTagCompound()
							nbt.setInteger("1", te.getSkill())
							stack.tagCompound = nbt
							te.setSkill(0)
							println(0)
						} else if (stack.tagCompound!!.getInteger("2") == 0) {
							stack.tagCompound!!.setInteger("2", te.getSkill())
							te.setSkill(0)
						} else if (stack.tagCompound!!.getInteger("3") == 0) {
							stack.tagCompound!!.setInteger("3", te.getSkill())
							te.setSkill(0)
						} else if (stack.tagCompound!!.getInteger("4") == 0) {
							stack.tagCompound!!.setInteger("4", te.getSkill())
							te.setSkill(0)
						}
					}
				}
			}
		}
	}
}