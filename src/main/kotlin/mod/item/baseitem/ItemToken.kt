package mod.item.baseitem

import mod.Core
import mod.enums.ItemRarity
import mod.module.IGeneralRarity
import net.minecraft.client.util.ITooltipFlag
import net.minecraft.entity.item.EntityItem
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.ActionResult
import net.minecraft.util.EnumActionResult
import net.minecraft.util.EnumHand
import net.minecraft.util.ResourceLocation
import net.minecraft.world.World
import java.util.*

open class ItemToken(name: String, private var rarity: ItemRarity): GeneralRPGItem(), IGeneralRarity{
	init {
		this.maxStackSize = 64
		this.unlocalizedName = name
		this.registryName = ResourceLocation(Core.ID, name)
	}

	override val itemRarity: ItemRarity = rarity

	override fun onItemRightClick(worldIn: World, playerIn: EntityPlayer, handIn: EnumHand): ActionResult<ItemStack> {
		if (this.rarity.skills.size != 0) {
			val random = Random().nextInt(this.rarity.skills.size)
			val item = EntityItem(worldIn, playerIn.posX, playerIn.posY, playerIn.posZ, ItemStack(this.rarity.skills[random]))
			if (!worldIn.isRemote) worldIn.spawnEntity(item)
			if (!playerIn.isCreative) playerIn.getHeldItem(handIn).count -= 1
		}
		println(this.rarity)
		return ActionResult(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn))
	}

	override fun addInformation(stack: ItemStack, worldIn: World?, tooltip: MutableList<String>, flagIn: ITooltipFlag) {
		indicateRarity(tooltip)
	}

	override fun getItemStackDisplayName(stack: ItemStack): String {
		return indicateDisplayRarity(super.getItemStackDisplayName(stack))
	}
}