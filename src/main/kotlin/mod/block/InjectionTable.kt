package mod.block

import mod.Core
import net.minecraft.block.BlockContainer
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.EnumBlockRenderType
import net.minecraft.util.ResourceLocation
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class InjectionTable: BlockContainer(Material.IRON){
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

	override fun getRenderType(state: IBlockState): EnumBlockRenderType {
		return EnumBlockRenderType.MODEL
	}

	override fun breakBlock(worldIn: World, pos: BlockPos, state: IBlockState) {
		super.breakBlock(worldIn, pos, state)
	}
}