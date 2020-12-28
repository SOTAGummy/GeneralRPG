package mod.gui.accessory

import mod.capability.accessory.AccessoryItemContainer
import mod.gui.accessory.slot.AmuletSlot
import mod.gui.accessory.slot.GemSlot
import mod.gui.accessory.slot.GloveSlot
import mod.gui.accessory.slot.NecklaceSlot
import net.minecraft.enchantment.EnchantmentHelper
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.player.InventoryPlayer
import net.minecraft.inventory.*
import net.minecraft.item.ItemArmor
import net.minecraft.item.ItemStack

class AccessoryContainer(val player: EntityPlayer, customInventory: AccessoryItemContainer): Container(){
	val playerInv: InventoryPlayer = player.inventory
	val inventory = AccessoryItemContainer()
	private val craftMatrix = InventoryCrafting(this, 2, 2)
	private val craftResult = InventoryCraftResult()
	private val equipmentSlots = arrayOf(EntityEquipmentSlot.HEAD, EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET)

	init {
		//ACCESSORYSLOT
		addSlotToContainer(NecklaceSlot(customInventory, 41, 114, 82))
		addSlotToContainer(AmuletSlot(customInventory, 42, 114, 100))
		addSlotToContainer(GloveSlot(customInventory, 43, 114, 118))
		addSlotToContainer(GemSlot(customInventory, 44, 114, 136))

		//ARMORSLOT
		for (k in 0..3) {
			val slot: EntityEquipmentSlot = equipmentSlots[k]
			addSlotToContainer(object : Slot(playerInv, 36 + (3 - k), 8, 8 + k * 18) {
				override fun getSlotStackLimit(): Int {
					return 1
				}

				override fun isItemValid(stack: ItemStack): Boolean {
					return stack.item.isValidArmor(stack, slot, player)
				}

				override fun canTakeStack(playerIn: EntityPlayer): Boolean {
					val itemstack = this.stack
					return if (!itemstack.isEmpty && !playerIn.isCreative && EnchantmentHelper.hasBindingCurse(itemstack)) false else super.canTakeStack(
						playerIn
					)
				}

				override fun getSlotTexture(): String? {
					return ItemArmor.EMPTY_SLOT_NAMES[slot.index]
				}
			})
		}

		//INVENTORYSLOT
		for (i in 0..2) {
			for (j in 0..8) {
				addSlotToContainer(Slot(playerInv, i * 9 + j + 9, 8 + j * 18, 84 + i * 18))
			}
		}

		//HOTBARSLOT
		for (i in 0..8) {
			addSlotToContainer(Slot(playerInv, i, 8 + i * 18, 142))
		}

		//OFFHANDSLOT
		addSlotToContainer(object : Slot(playerInv, 40, 96, 62) {
			override fun isItemValid(stack: ItemStack): Boolean {
				return super.isItemValid(stack)
			}

			override fun getSlotTexture(): String {
				return "minecraft:items/empty_armor_slot_shield"
			}
		})

		//CRAFTMTRIXSLOT
		for (i in 0..1) {
			for (j in 0..1) {
				addSlotToContainer(Slot(craftMatrix, j + i * 2, 116 + j * 18, 18 + i * 18))
			}
		}

		//CRAFTRESULTSLOT
		addSlotToContainer(SlotCrafting(playerInv.player, craftMatrix, craftResult, 0, 154, 28))

		this.onCraftMatrixChanged(craftMatrix);
	}

	override fun canInteractWith(playerIn: EntityPlayer): Boolean {
		return true
	}

	override fun onCraftMatrixChanged(par1IInventory: IInventory?) {
		slotChangedCraftingGrid(player.entityWorld, player, craftMatrix, this.craftResult)
	}

	override fun onContainerClosed(player: EntityPlayer) {
		super.onContainerClosed(player)
		craftResult.clear()
		if (!player.world.isRemote) {
			clearContainer(player, player.world, craftMatrix)
		}
	}

	override fun canMergeSlot(stack: ItemStack?, slot: Slot): Boolean {
		return slot.inventory !== craftResult && super.canMergeSlot(stack, slot)
	}

	override fun transferStackInSlot(playerIn: EntityPlayer, index: Int): ItemStack {
		var itemstack = ItemStack.EMPTY
		val slot = inventorySlots[index] as Slot

		if (slot != null && slot.hasStack){

		}
		return itemstack
	}
}