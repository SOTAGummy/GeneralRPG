package mod.gui.accessory

import mod.item.baseitem.ItemAccessory
import mod.util.Attributes
import net.minecraft.entity.ai.attributes.IAttribute
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.EntityEquipmentSlot
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.world.World
import net.minecraftforge.fml.common.network.IGuiHandler

class GuiAccessoryHandler: IGuiHandler{
	companion object{
		const val AccessoryGui = 1
	}

	override fun getClientGuiElement(ID: Int, player: EntityPlayer?, world: World?, x: Int, y: Int, z: Int): Any? {
		if (ID == AccessoryGui){
			val customInv = AccessoryItemContainer()
			val accessory: MutableList<IAttribute> = ArrayList(4)
			accessory.add(0, Attributes.NECKLACE)
			accessory.add(1, Attributes.AMULET)
			accessory.add(2, Attributes.GLOVE)
			accessory.add(3, Attributes.GEM)

			player?.let {
				for(i in 0 .. 3) {
					val id = player.getEntityAttribute(accessory[i]).attributeValue.toInt()
					val item = Item.getItemById(id)
					if (item is ItemAccessory && item.equipmentSlot == EntityEquipmentSlot.values()[i + 6])
						customInv.setStackInSlot(i, ItemStack(Item.getItemById(id)))
				}
			}
			return player?.let { GuiAccessoryContainer(it, customInv) }
		}
		return null
	}

	override fun getServerGuiElement(ID: Int, player: EntityPlayer?, world: World?, x: Int, y: Int, z: Int): Any? {
		if (ID == AccessoryGui){
			val customInv = AccessoryItemContainer()
			val accessory: MutableList<IAttribute> = ArrayList(4)
			accessory.add(0, Attributes.NECKLACE)
			accessory.add(1, Attributes.AMULET)
			accessory.add(2, Attributes.GLOVE)
			accessory.add(3, Attributes.GEM)

			player?.let {
				for (i in 0 .. 3){
					val id = player.getEntityAttribute(accessory[i]).attributeValue.toInt()
					val item = Item.getItemById(id)
					if (item is ItemAccessory && item.equipmentSlot == EntityEquipmentSlot.values()[i + 6])
						customInv.setStackInSlot(i, ItemStack(Item.getItemById(id)))
				}
			}
			return player?.let { AccessoryContainer(it, AccessoryItemContainer()) }
		}
		return null
	}
}