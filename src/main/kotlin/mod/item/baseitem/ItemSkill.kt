package mod.item.baseitem

import mod.Core
import mod.item.skill.SkillRarity
import mod.util.Storage
import net.minecraft.client.resources.I18n
import net.minecraft.client.util.ITooltipFlag
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.EnumHand
import net.minecraft.util.ResourceLocation
import net.minecraft.util.text.TextFormatting
import net.minecraft.world.World

open class ItemSkill(name: String, val cost: Int, val rarity: SkillRarity) : GeneralRPGItem() {
	init {
		this.unlocalizedName = name
		this.maxStackSize = 1
		this.creativeTab = Core.skillTab
		this.registryName = ResourceLocation(Core.ID, name)
		Cost = cost
		Rarity = rarity
		Storage.Skills.add(this)
		rarity.skills.add(this)
	}

	companion object {
		var Cost = 0
		var Rarity = SkillRarity.COMMON
	}

	override fun addInformation(stack: ItemStack, worldIn: World?, tooltip: MutableList<String>, flagIn: ITooltipFlag) {
		super.addInformation(stack, worldIn, tooltip, flagIn)
		val rarityFormat = I18n.format(rarity.toString())
		val item = stack.item as ItemSkill
		val rarity = item.rarity

		tooltip.add("Rarity : " + "${rarity.colorChar}${TextFormatting.BOLD}$rarityFormat")
	}

	open fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand, saveRate: Int) {}
}