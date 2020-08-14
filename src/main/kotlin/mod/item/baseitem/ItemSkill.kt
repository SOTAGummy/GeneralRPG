package mod.item.baseitem

import mod.Core
import mod.item.skill.SkillFunctions
import mod.util.Storage
import net.minecraft.client.resources.I18n
import net.minecraft.client.util.ITooltipFlag
import net.minecraft.item.ItemStack
import net.minecraft.util.ResourceLocation
import net.minecraft.util.text.TextFormatting
import net.minecraft.world.World

open class ItemSkill(private val name: String) : GeneralRPGItem() {
	init {
		this.unlocalizedName = name
		this.maxStackSize = 1
		this.creativeTab = Core.skillTab
		this.registryName = ResourceLocation(Core.ID, name)

		Storage.Skills.add(this)
	}

	override fun addInformation(stack: ItemStack, worldIn: World?, tooltip: MutableList<String>, flagIn: ITooltipFlag) {
		super.addInformation(stack, worldIn, tooltip, flagIn)
		val rarity = SkillFunctions.valueOf(name.toUpperCase()).rare
		val format = I18n.format(rarity.toString())
		tooltip.add("${rarity.colorChar}${TextFormatting.BOLD}$format")
	}
}