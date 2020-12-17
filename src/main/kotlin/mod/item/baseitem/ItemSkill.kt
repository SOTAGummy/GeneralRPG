package mod.item.baseitem

import mod.Core
import mod.enums.ItemRarity
import mod.module.IGeneralRarity
import mod.util.JsonReference
import mod.util.Storage
import net.minecraft.client.resources.I18n
import net.minecraft.client.util.ITooltipFlag
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.EnumHand
import net.minecraft.util.ResourceLocation
import net.minecraft.util.text.TextComponentTranslation
import net.minecraft.util.text.TextFormatting
import net.minecraft.world.World
import java.io.File

open class ItemSkill(val name: String, val cost: Double, val rarity: ItemRarity, includeEvents: Boolean = false) :
	GeneralRPGItem(), IGeneralRarity {
	init {
		this.unlocalizedName = name
		this.maxStackSize = 1
		this.creativeTab = Core.skillTab
		this.registryName = ResourceLocation(Core.ID, name)
		Cost = cost
		Storage.Skills.add(this)
		rarity.skills.add(this)
		if (includeEvents) Storage.Instances.add(this)

		val file = File("D:\\mod\\GeneralRPG\\src\\main\\resources\\assets\\general-rpg\\models\\item\\$name.json")
		if (!file.exists()) {
			file.createNewFile()
			file.writeText(JsonReference.ItemSkillJsonText)
		}
	}

	companion object {
		var Cost = 0.0
	}

	override val itemRarity: ItemRarity = rarity

	override fun addInformation(stack: ItemStack, worldIn: World?, tooltip: MutableList<String>, flagIn: ITooltipFlag) {
		super.addInformation(stack, worldIn, tooltip, flagIn)
		val costFormat = I18n.format(cost.toString())
		stack.item as ItemSkill
		tooltip.add("${TextComponentTranslation("text.skill_cost").formattedText} : ${TextFormatting.BOLD}$costFormat")
		indicateRarity(tooltip)
	}

	open fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {}
}