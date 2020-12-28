package mod.gui.accessory

import mod.capability.accessory.AccessoryItemContainer
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World
import net.minecraftforge.fml.common.network.IGuiHandler

class GuiAccessoryHandler: IGuiHandler{
	companion object{
		const val AccessoryGui = 1
	}

	override fun getClientGuiElement(ID: Int, player: EntityPlayer?, world: World?, x: Int, y: Int, z: Int): Any? {
		if (ID == AccessoryGui)
			return player?.let { GuiAccessoryContainer(it, AccessoryItemContainer()) }
		return null
	}

	override fun getServerGuiElement(ID: Int, player: EntityPlayer?, world: World?, x: Int, y: Int, z: Int): Any? {
		if (ID == AccessoryGui)
			return player?.let { AccessoryContainer(it, AccessoryItemContainer()) }
		return null
	}
}