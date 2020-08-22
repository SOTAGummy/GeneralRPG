package mod.item.baseitem

import mod.Core
import mod.item.skill.SkillRarity
import net.minecraft.entity.item.EntityItem
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.ActionResult
import net.minecraft.util.EnumActionResult
import net.minecraft.util.EnumHand
import net.minecraft.util.ResourceLocation
import net.minecraft.world.World
import java.util.*

open class ItemToken(val name: String, rarity: SkillRarity): GeneralRPGItem(){
	init {
		this.maxStackSize = 64
		this.unlocalizedName = name
		this.registryName = ResourceLocation(Core.ID, name)
		Rarity = rarity
	}

	companion object {
		var Rarity: SkillRarity = SkillRarity.COMMON
	}

	override fun onItemRightClick(worldIn: World, playerIn: EntityPlayer, handIn: EnumHand): ActionResult<ItemStack> {
		val random = Random().nextInt(Rarity.skills.size)
		val item = EntityItem(worldIn, playerIn.posX, playerIn.posY, playerIn.posZ, ItemStack(Rarity.skills[random]))
		worldIn.spawnEntity(item)
		if (!playerIn.isCreative) playerIn.getHeldItem(handIn).count -= 1
		return ActionResult(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn))
	}
}