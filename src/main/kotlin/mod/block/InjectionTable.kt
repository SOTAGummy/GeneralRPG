package mod.block

import mod.Core
import mod.entity.AnimateItem
import mod.item.baseitem.ItemSkill
import mod.item.baseitem.ItemSkillContainer
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
	companion object{
		var entity: AnimateItem? = null
	}

	init {
		this.setCreativeTab(Core.creativeaTab)
		this.unlocalizedName = "injection_table"
		this.registryName = ResourceLocation(Core.ID, "injection_table")
		this.setHardness(7.0F)
		this.setResistance(10.0F)
	}

	override fun createNewTileEntity(worldIn: World, meta: Int): TileEntity? {
		return TileEntityInjectionTable()
	}

	override fun getRenderType(state: IBlockState?): EnumBlockRenderType? {
		return EnumBlockRenderType.MODEL
	}

	override fun onBlockActivated(world: World, pos: BlockPos?, state: IBlockState?, player: EntityPlayer?, hand: EnumHand?, side: EnumFacing?, hitX: Float, hitY: Float, hitZ: Float): Boolean {
		val te: TileEntityInjectionTable? = world.getTileEntity(pos) as TileEntityInjectionTable?
		val stack = player!!.getHeldItem(hand)
		val sneak = player.isSneaking

		if (!world.isRemote) {
			when (te?.getSkill()) {
				0 -> {
					if (stack.item is ItemSkill) {
						te.setSkill(Item.getIdFromItem(stack.item))
						player.setHeldItem(EnumHand.MAIN_HAND, ItemStack.EMPTY)

						val skill = ItemStack(Item.getItemById(te.getSkill()))
						val item = AnimateItem(world, pos!!.x.toDouble() + 0.5, (pos.y + 1).toDouble(), pos.z.toDouble() + 0.5, skill, skill.displayName)
						entity = item
						if (world.isRemote) world.spawnEntity(entity)
					}
				}

				else -> {
					if (stack.item is ItemSkillContainer) {
						if (stack.tagCompound == null) {
							val nbt = NBTTagCompound()
							nbt.setInteger("1", te!!.getSkill())
							stack.tagCompound = nbt
							te!!.setSkill(0)
						}

						repeat((stack.item as ItemSkillContainer).capacity){
							if (stack.tagCompound!!.getInteger((it + 1).toString()) == 0) {
								stack.tagCompound!!.setInteger((it + 1).toString(), te!!.getSkill())
								te.setSkill(0)
							}

							if (entity != null) world.removeEntity(entity)
							entity = null
						}

					}else if (stack == ItemStack.EMPTY && sneak){
						player.setHeldItem(hand, ItemStack(Item.getItemById(te!!.getSkill())))
						te!!.setSkill(0)
						world.removeEntity(entity)
						entity = null
					}
				}
			}
		}
		return true
	}

	override fun breakBlock(world: World?, pos: BlockPos?, state: IBlockState?) {
		val te = world?.getTileEntity(pos as BlockPos) as TileEntityInjectionTable
		if (te.getSkill() != 0) {
			val item = EntityItem(world, pos?.x!!.toDouble(), pos.y.toDouble(), pos.z.toDouble(), ItemStack(Item.getItemById(te.getSkill())))
			world.spawnEntity(item)
			te.setSkill(0)
		}
		world.removeTileEntity(pos)
		if (entity != null) world.removeEntity(entity)
		super.breakBlock(world, pos as BlockPos, state as IBlockState)
	}
}