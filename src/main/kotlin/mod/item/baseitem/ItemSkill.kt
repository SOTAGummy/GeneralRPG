package mod.item.baseitem

import mod.Core
import mod.enums.SkillRarity
import mod.json.ItemSkillJsonReference
import mod.util.Storage
import net.minecraft.client.resources.I18n
import net.minecraft.client.util.ITooltipFlag
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.EnumHand
import net.minecraft.util.ResourceLocation
import net.minecraft.util.text.TextFormatting
import net.minecraft.world.World
import java.io.File

open class ItemSkill(val name: String, val cost: Int, val rarity: SkillRarity, val includeEvents: Boolean) : GeneralRPGItem() {
	init {
		this.unlocalizedName = name
		this.maxStackSize = 1
		this.creativeTab = Core.skillTab
		this.registryName = ResourceLocation(Core.ID, name)
		Cost = cost
		Rarity = rarity
		Storage.Skills.add(this)
		rarity.skills.add(this)
		if (includeEvents) Storage.Instances.add(this)

		val file = File("D:\\mod\\GeneralRPG\\src\\main\\resources\\assets\\general-rpg\\models\\item\\$name.json")
		if (!file.exists()) {
			file.createNewFile()
			file.writeText(ItemSkillJsonReference.jsonText)
		}
	}

	companion object {
		var Cost = 0
		var Rarity = SkillRarity.COMMON
	}

	override fun addInformation(stack: ItemStack, worldIn: World?, tooltip: MutableList<String>, flagIn: ITooltipFlag) {
		super.addInformation(stack, worldIn, tooltip, flagIn)
		val rarityFormat = I18n.format(rarity.toString())
		val costFormat = I18n.format(cost.toString())
		val item = stack.item as ItemSkill
		val rarity = item.rarity

		tooltip.add("Cost : ${TextFormatting.BOLD}$costFormat")
		tooltip.add("Rarity : ${rarity.colorChar}${TextFormatting.BOLD}$rarityFormat")
	}

	open fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand, savingRate: Float) {}
}