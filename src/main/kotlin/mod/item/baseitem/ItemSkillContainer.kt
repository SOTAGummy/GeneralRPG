package mod.item.baseitem

import com.google.common.collect.Multimap
import mod.Core
import mod.enums.ItemRarity
import mod.module.IGeneralRarity
import mod.module.ISkillStorable
import mod.pppSystem.PPPSystem
import mod.pppSystem.UniqueBinaryOperator
import mod.util.Attributes
import mod.util.UUIDReference
import net.minecraft.client.resources.I18n
import net.minecraft.client.util.ITooltipFlag
import net.minecraft.entity.ai.attributes.AttributeModifier
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.EntityEquipmentSlot
import net.minecraft.item.EnumAction
import net.minecraft.item.ItemStack
import net.minecraft.util.ActionResult
import net.minecraft.util.EnumActionResult
import net.minecraft.util.EnumHand
import net.minecraft.util.ResourceLocation
import net.minecraft.util.text.TextComponentTranslation
import net.minecraft.util.text.TextFormatting
import net.minecraft.world.World

open class ItemSkillContainer(
	name: String,
	rarity: ItemRarity,
	val capacity: Int,
	private val coolDown: Int,
	val savingRate: Double
) : GeneralRPGItem(), IGeneralRarity, ISkillStorable {
	init {
		this.unlocalizedName = name
		this.creativeTab = Core.modTab
		this.maxStackSize = 1
		this.registryName = ResourceLocation(Core.ID, name)
	}

	override val itemRarity: ItemRarity = rarity
	override val storeCap: Int = capacity

	override fun addInformation(stack: ItemStack, worldIn: World?, tooltip: MutableList<String>, flagIn: ITooltipFlag) {
		super.addInformation(stack, worldIn, tooltip, flagIn)
		var cost = 0.0
		for (i in 0 until capacity) {
			if (stack.tagCompound != null && stack.tagCompound!!.getIntArray("SkillArray")[i] != 0) {
				val itemStack = ItemStack(getItemById(stack.tagCompound!!.getIntArray("SkillArray")[i])).displayName
				val displayName = itemStack.split(" ")[0]
				val format = I18n.format(displayName)
				val item = (getItemById(stack.tagCompound!!.getIntArray("SkillArray")[i])) as ItemSkill
				val color = item.getGeneralRarity().colorChar
				val count = (i + 1).toString()

				cost += item.cost
				cost.toInt()
				tooltip.add("$count : $color${TextFormatting.UNDERLINE}$format")
			}
		}
		if (stack.tagCompound != null) {
			tooltip.add("")
			tooltip.add("${TextComponentTranslation("text.skill_cost").formattedText} : " + cost.toString() + "MP")
		}
		tooltip.add(
			"${TextComponentTranslation("text.cooldown").formattedText} : ${coolDown.toFloat() / 20F}${
				TextComponentTranslation(
					"text.second"
				).formattedText
			}"
		)
		indicateRarity(tooltip)
	}

	override fun onItemRightClick(world: World, player: EntityPlayer, handIn: EnumHand): ActionResult<ItemStack> {
		val itemstack = player.getHeldItem(handIn)
		player.activeHand = handIn
		if (itemstack.tagCompound != null) {
			for (i in 0 until capacity) {
				if (itemstack.tagCompound!!.getIntArray("SkillArray")[i] != 0) {
					val item = (getItemById(itemstack.tagCompound!!.getIntArray("SkillArray")[i])) as ItemSkill
					val skillFunc = object : UniqueBinaryOperator {
						override val World: World = world
						override val Player: EntityPlayer = player
						override val Hand: EnumHand = handIn

						override fun call(world: World, player: EntityPlayer, hand: EnumHand) {
							item.skillFunction(world, player, hand)
						}
					}
					PPPSystem.addProcess(skillFunc)
					PPPSystem.addDelay(10)
				}
			}
		}
		player.cooldownTracker.setCooldown(this, coolDown)
		return ActionResult(EnumActionResult.SUCCESS, itemstack)
	}

	override fun getItemUseAction(stack: ItemStack): EnumAction {
		return EnumAction.BLOCK
	}

	override fun getAttributeModifiers(
		slot: EntityEquipmentSlot,
		stack: ItemStack
	): Multimap<String, AttributeModifier> {
		val multimap = super.getAttributeModifiers(slot, stack)
		return if (slot == EntityEquipmentSlot.MAINHAND && savingRate != 0.0) {
			multimap.put(
				Attributes.SAVINGRATE.name,
				AttributeModifier(UUIDReference.ItemSkillContainerSavingRate, "savingrate", savingRate, 0)
			)
			multimap
		} else {
			super.getAttributeModifiers(slot, stack)
		}
	}

	override fun getItemStackDisplayName(stack: ItemStack): String {
		return indicateDisplayRarity(super.getItemStackDisplayName(stack))
	}
}