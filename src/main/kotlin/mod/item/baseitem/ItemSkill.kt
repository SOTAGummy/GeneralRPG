package mod.item.baseitem

import com.google.gson.stream.JsonWriter
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
import java.io.File
import java.io.FileWriter

open class ItemSkill(val name: String, val cost: Int, val rarity: SkillRarity) : GeneralRPGItem() {
	init {
		this.unlocalizedName = name
		this.maxStackSize = 1
		this.creativeTab = Core.skillTab
		this.registryName = ResourceLocation(Core.ID, name)
		Cost = cost
		Rarity = rarity
		Storage.Skills.add(this)
		rarity.skills.add(this)

		val path = "D:\\mod\\GeneralRPG\\src\\main\\resources\\assets\\general-rpg\\models\\item\\$name.json"
		val json = JsonWriter(FileWriter(path))

		json.beginObject() // {
		json.name("parent").value("item/generated") // "parent" : "item/generated"
		json.name("textures") // "textures : "
		json.beginObject() // {
		json.name("layer0").value("general-rpg:items/itemskill") // "layer0" : "general-rpg:items/itemskill"
		json.endObject() // }
		json.endObject() // }
		json.close()
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

	open suspend fun skillFunction(world: World, player: EntityPlayer, handIn: EnumHand) {}
}