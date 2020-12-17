package mod.gui.skilllist

import mod.Core
import mod.item.baseitem.ItemSkill
import mod.item.baseitem.ItemSkillContainer
import mod.module.ISkillStorable
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.Gui
import net.minecraft.client.gui.ScaledResolution
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.EnumHand
import net.minecraft.util.ResourceLocation
import java.awt.Color

class SkillListIndicator(mc: Minecraft) : Gui() {
	init {
		val player = mc.player
		if (player.getHeldItem(EnumHand.MAIN_HAND).item is ItemSkillContainer) {
			val capacity = (player.getHeldItem(EnumHand.MAIN_HAND).item as ISkillStorable).storeCap
			var count = 0
			var length = 0
			val scaled = ScaledResolution(mc)
			val height = scaled.scaledHeight
			for (i in 0 until capacity) {
				if (player.getHeldItem(EnumHand.MAIN_HAND).tagCompound != null && player.getHeldItem(EnumHand.MAIN_HAND).tagCompound!!.getIntArray("SkillArray")[i] != 0) {
					count++
					val text = ItemStack(Item.getItemById(player.getHeldItem(EnumHand.MAIN_HAND).tagCompound!!.getIntArray("SkillArray")[i])).displayName.split(" ")[0]
					if (text.length > length) length = text.length
					val item = Item.getItemById(player.getHeldItem(EnumHand.MAIN_HAND).tagCompound!!.getIntArray("SkillArray")[i]) as ItemSkill
					mc.ingameGUI.drawString(mc.fontRenderer, text, 10, (height / 2 - 10) + 8 * i, item.rarity.colorCode)
				}
			}
			mc.ingameGUI.drawString(mc.fontRenderer, "", 0, 0, Color.BLACK.rgb)
			mc.textureManager.bindTexture(ResourceLocation(Core.ID + ":textures/gui/background.png"))
			mc.ingameGUI.drawTexturedModalRect(10, height / 2 - 10, 0, 0, length * 7, 8 * count)
		}
	}
}