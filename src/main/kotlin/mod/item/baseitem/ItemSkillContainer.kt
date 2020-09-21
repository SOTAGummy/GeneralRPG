package mod.item.baseitem

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import mod.Core
import net.minecraft.client.resources.I18n
import net.minecraft.client.util.ITooltipFlag
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.EnumAction
import net.minecraft.item.ItemStack
import net.minecraft.util.ActionResult
import net.minecraft.util.EnumActionResult
import net.minecraft.util.EnumHand
import net.minecraft.util.ResourceLocation
import net.minecraft.util.text.TextComponentTranslation
import net.minecraft.util.text.TextFormatting
import net.minecraft.world.World
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

open class ItemSkillContainer(name: String, val capacity: Int, private val coolDown: Int, val savingRate: Float): GeneralRPGItem() {
	init {
		this.unlocalizedName = name
		this.creativeTab = Core.modTab
		this.maxStackSize = 1
		this.registryName = ResourceLocation(Core.ID, name)
	}

	override fun addInformation(stack: ItemStack, worldIn: World?, tooltip: MutableList<String>, flagIn: ITooltipFlag) {
		super.addInformation(stack, worldIn, tooltip, flagIn)
		var cost = 0

		repeat(capacity + 1) {
			if (stack.tagCompound != null && stack.tagCompound!!.getInteger((it + 1).toString()) != 0) {
				val format = I18n.format(ItemStack(getItemById(stack.tagCompound!!.getInteger((it + 1).toString()))).displayName)
				val item = (getItemById(stack.tagCompound!!.getInteger((it + 1).toString()))) as ItemSkill
				val color = item.rarity.colorChar
				val count = (it + 1).toString()

				cost += item.cost
				tooltip.add("$count : $color${TextFormatting.UNDERLINE}$format")
			}
		}

		if (stack.tagCompound != null) {
			tooltip.add("")
			tooltip.add("${TextComponentTranslation("text.skill_cost").formattedText} : " + cost.toString() + "MP")
		}
		tooltip.add("${TextComponentTranslation("text.saving_rate").formattedText} : $savingRate%")
		tooltip.add("${TextComponentTranslation("text.cooldown").formattedText} : ${coolDown.toFloat() / 20F}${TextComponentTranslation("text.second").formattedText}")
	}

	@SideOnly(Side.CLIENT)
	override fun onItemRightClick(world: World, player: EntityPlayer, handIn: EnumHand): ActionResult<ItemStack> {
		val itemstack = player.getHeldItem(handIn)
		player.activeHand = handIn
		if (itemstack.tagCompound != null) {
			repeat(capacity + 1) {
				if (itemstack.tagCompound!!.getInteger((it + 1).toString()) != 0) {
					val item = (getItemById(itemstack.tagCompound!!.getInteger((it + 1).toString()))) as ItemSkill
					GlobalScope.launch {
						item.skillFunction(world, player, handIn, savingRate)
						launch {
							delay(500)
						}.join()
					}
				}
			}
		}
		player.cooldownTracker.setCooldown(this, coolDown)
		return ActionResult(EnumActionResult.SUCCESS, itemstack)
	}

	override fun getItemUseAction(stack: ItemStack): EnumAction {
		return EnumAction.BLOCK
	}
}