package mod.block

import mod.Core
import mod.entity.AnimateItem
import mod.item.baseitem.ItemSkill
import mod.item.baseitem.ItemSkillContainer
import net.minecraft.block.Block
import net.minecraft.block.BlockContainer
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.Entity
import net.minecraft.entity.item.EntityItem
import net.minecraft.entity.item.EntityItemFrame
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Blocks
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.tileentity.MobSpawnerBaseLogic
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.EnumBlockRenderType
import net.minecraft.util.EnumFacing
import net.minecraft.util.EnumHand
import net.minecraft.util.ResourceLocation
import net.minecraft.util.math.AxisAlignedBB
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import java.util.*


class InjectionTable : Block(Material.IRON) {
	companion object{
		var entityMap = mutableMapOf<BlockPos, AnimateItem>()
		var IDMap = mutableMapOf<BlockPos, Int>()
	}

	init {
		this.setCreativeTab(Core.creativeaTab)
		this.unlocalizedName = "injection_table"
		this.registryName = ResourceLocation(Core.ID, "injection_table")
		this.setHardness(7.0F)
		this.setResistance(10.0F)
	}

	override fun getRenderType(state: IBlockState?): EnumBlockRenderType? {
		return EnumBlockRenderType.MODEL
	}

	override fun onBlockActivated(world: World, pos: BlockPos?, state: IBlockState?, player: EntityPlayer?, hand: EnumHand?, side: EnumFacing?, hitX: Float, hitY: Float, hitZ: Float): Boolean {
		val stack = player?.getHeldItem(hand)
		val itemPos = BlockPos(pos!!.x.toDouble() + 0.5, pos.y.toDouble() + 1.0, pos.z.toDouble() + 0.5)
		val item = AnimateItem(world, pos.x.toDouble() + 0.5, pos.y.toDouble() + 1.0, pos.z.toDouble() + 0.5, stack!!, stack.displayName)

		if (!world.isRemote){
			if (stack.item is ItemSkill){
				player.setHeldItem(hand, ItemStack.EMPTY)
			}
		}
		if (world.isRemote){
			if (stack.item is ItemSkill){
				world.spawnEntity(item)
				entityMap[BlockPos(item.posX, item.posY, item.posZ)] = item
				IDMap[pos] = Item.getIdFromItem(stack.item)
			}
		}
		return true
	}

	override fun breakBlock(world: World, pos: BlockPos?, state: IBlockState?) {
		val itemPos = BlockPos(pos!!.x + 0.5, pos.y + 1.0, pos.z + 0.5)

		if (IDMap[pos] != null){
			val item = EntityItem(world, pos.x.toDouble(), pos.y.toDouble(), pos.z.toDouble(), ItemStack(Item.getItemById(IDMap[pos]!!)))
			item.setNoPickupDelay()
			world.spawnEntity(item)
			world.removeEntity(entityMap[itemPos])
		}
		super.breakBlock(world, pos, state as IBlockState)
	}
}