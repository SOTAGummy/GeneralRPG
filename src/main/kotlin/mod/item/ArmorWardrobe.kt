package mod.item

import mod.Core
import mod.item.baseitem.GeneralRPGItem
import net.minecraft.item.ItemStack
import net.minecraft.util.ResourceLocation
import net.minecraftforge.items.IItemHandler

object ArmorWardrobe : GeneralRPGItem(), IItemHandler {


	init {
		this.maxStackSize = 1
		this.unlocalizedName = "armor_wardrobe"
		this.registryName = ResourceLocation(Core.ID, "armor_wardrobe")
	}

	override fun getSlots(): Int {
		return 36
	}

	override fun getSlotLimit(slot: Int): Int {
		return 1
	}

	override fun getStackInSlot(slot: Int): ItemStack {
		TODO("Not yet implemented")
	}

	override fun insertItem(slot: Int, stack: ItemStack, simulate: Boolean): ItemStack {
		TODO("Not yet implemented")
	}

	override fun extractItem(slot: Int, amount: Int, simulate: Boolean): ItemStack {
		TODO("Not yet implemented")
	}
}
