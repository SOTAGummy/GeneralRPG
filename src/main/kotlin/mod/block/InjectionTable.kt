package mod.block

import mod.Core
import mod.entity.AnimateItem
import mod.item.baseitem.ItemSkill
import mod.module.ISkillStorable
import net.minecraft.block.BlockContainer
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.item.EntityItem
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.EnumBlockRenderType
import net.minecraft.util.EnumFacing
import net.minecraft.util.EnumHand
import net.minecraft.util.ResourceLocation
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World


class InjectionTable : BlockContainer(Material.IRON) {
	init {
		this.setCreativeTab(Core.modTab)
		this.unlocalizedName = "injection_table"
		this.registryName = ResourceLocation(Core.ID, "injection_table")
		this.setHardness(7.0F)
		this.setResistance(10.0F)
	}

	override fun getRenderType(state: IBlockState?): EnumBlockRenderType? {
		return EnumBlockRenderType.MODEL
	}

	override fun createNewTileEntity(worldIn: World, meta: Int): TileEntity? {
		return TileEntityInjectionTable()
	}

	override fun onBlockActivated(
		world: World,
		pos: BlockPos,
		state: IBlockState,
		player: EntityPlayer,
		hand: EnumHand,
		facing: EnumFacing,
		hitX: Float,
		hitY: Float,
		hitZ: Float
	): Boolean {
		if (!world.isRemote && hand == EnumHand.MAIN_HAND) {
			val te = world.getTileEntity(pos) as TileEntityInjectionTable
			val stack = player.getHeldItem(hand)
			when {
				stack.item is ItemSkill -> {
					if (te.getEntity() == null) {
						val item = AnimateItem(
							world,
							pos.x.toDouble() + 0.5,
							(pos.y + 1).toDouble(),
							pos.z.toDouble() + 0.5,
							player.getHeldItem(hand)
						)
						te.setEntity(item)
						world.spawnEntity(item)
					}
					if (te.getStack() == ItemStack.EMPTY) {
						te.setStack(player.getHeldItem(hand))
						val next = ItemStack(stack.item, stack.count - 1)
						player.setHeldItem(hand, next)
					}
				}
				stack.item is ISkillStorable -> {
					val capacity = (stack.item as ISkillStorable).storeCap
					if (!te.getStack().isEmpty) {
						if (stack.tagCompound == null) {
							val nbt = NBTTagCompound()
							val array = IntArray(capacity)
							array[0] = Item.getIdFromItem(te.getStack().item)
							nbt.setIntArray("SkillArray", array)
							stack.tagCompound = nbt
							player.setHeldItem(hand, stack)
							te.setStack(ItemStack.EMPTY)
							world.removeEntity(te.getEntity())
							te.setEntity(null)
						} else if (stack.tagCompound != null && stack.tagCompound!!.getIntArray("SkillArray").size <= capacity) {
							val nbt = stack.tagCompound!!
							val array = nbt.getIntArray("SkillArray")
							var index = 0
							repeat(capacity) {
								if (array[it] == 0) {
									index = it
									return@repeat
								}
							}
							array[index] = Item.getIdFromItem(te.getStack().item)
							nbt.setIntArray("SkillArray", array)
							stack.tagCompound = nbt
							player.setHeldItem(hand, stack)
							te.setStack(ItemStack.EMPTY)
							world.removeEntity(te.getEntity())
							te.setEntity(null)
						}
					}
				}
				stack.isEmpty -> {
					player.setHeldItem(hand, te.getStack())
					te.setStack(ItemStack.EMPTY)
					if (te.getEntity() != null)
						world.removeEntity(te.getEntity())
					te.setEntity(null)
				}
			}
		}
		return super.onBlockActivated(world, pos, state, player, hand, facing, hitX, hitY, hitZ)
	}

	override fun breakBlock(world: World, pos: BlockPos, state: IBlockState) {
		val te = world.getTileEntity(pos) as TileEntityInjectionTable
		val stack = te.getStack()
		if (te.getEntity() != null) world.removeEntity(te.getEntity())
		world.removeTileEntity(pos)
		val item = EntityItem(world, pos.x.toDouble(), pos.y.toDouble(), pos.z.toDouble(), stack)
		item.setPickupDelay(0)
		world.spawnEntity(item)
		super.breakBlock(world, pos, state)
	}
}