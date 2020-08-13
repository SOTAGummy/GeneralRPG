package mod.event.bindSkillEvent

import mod.block.TileEntityInjectionTable
import mod.item.baseitem.ItemSkill
import mod.item.items.SkillBook
import net.minecraft.item.Item
import net.minecraft.item.Item.getItemById
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

	}
}