package mod.item.baseitem

import mod.Core
import mod.enums.ItemRarity
import mod.util.JsonReference
import net.minecraft.util.ResourceLocation
import java.io.File

open class ItemAccessory(name: String, rarity: ItemRarity): GeneralRPGItem(rarity){
	init {
		this.creativeTab = Core.accessoryTab
		this.registryName = ResourceLocation(Core.ID, name)
		this.unlocalizedName = name
		this.maxStackSize = 1

		val file = File("D:\\mod\\GeneralRPG\\src\\main\\resources\\assets\\general-rpg\\models\\item\\$name.json")
		if (!file.exists()) {
			file.createNewFile()
			file.writeText(JsonReference.getJsonText(name))
		}
	}
}