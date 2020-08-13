package mod.block

import mod.Core
import net.minecraft.block.BlockContainer
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.item.EntityItem
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.EnumBlockRenderType
import net.minecraft.util.EnumFacing
import net.minecraft.util.EnumHand
import net.minecraft.util.ResourceLocation
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World


class InjectionTable : BlockContainer(Material.IRON) {
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
		if (!world.isRemote) {
			val te: TileEntityInjectionTable? = world.getTileEntity(pos) as TileEntityInjectionTable?
		}
		return true
	}

	override fun breakBlock(world: World?, pos: BlockPos?, state: IBlockState?) {
		val te = world?.getTileEntity(pos as BlockPos) as TileEntityInjectionTable
		if (te.getSkill() != -1) {
			val item = EntityItem(world, pos?.x!!.toDouble(), pos?.y.toDouble(), pos?.z.toDouble(), ItemStack(Item.getItemById(te.getSkill())))
			world.spawnEntity(item)
		}
		super.breakBlock(world, pos as BlockPos, state as IBlockState)
		world.removeTileEntity(pos)
	}
}