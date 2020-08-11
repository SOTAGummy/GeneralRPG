package mod.block

import mod.Core
import net.minecraft.block.BlockContainer
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.item.EntityItem
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.EnumBlockRenderType
import net.minecraft.util.EnumFacing
import net.minecraft.util.EnumHand
import net.minecraft.util.ResourceLocation
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraftforge.items.CapabilityItemHandler

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

	override fun getRenderType(state: IBlockState): EnumBlockRenderType {
		return EnumBlockRenderType.MODEL
	}

	override fun breakBlock(worldIn: World, pos: BlockPos, state: IBlockState) {
		val te = worldIn.getTileEntity(pos) as TileEntityInjectionTable
		val itemhandler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH)
		for (i in 0..1) {
			if (!itemhandler?.getStackInSlot(i)?.isEmpty!!) {
				var item = EntityItem(worldIn, pos.x.toDouble(), pos.y.toDouble(), pos.z.toDouble(), itemhandler.getStackInSlot(i))
				worldIn.spawnEntity(item)
			}
		}
		super.breakBlock(worldIn, pos, state)
	}

	override fun onBlockActivated(worldIn: World, pos: BlockPos, state: IBlockState, playerIn: EntityPlayer, hand: EnumHand, facing: EnumFacing, hitX: Float, hitY: Float, hitZ: Float): Boolean {
		if (!worldIn.isRemote){
			var te = worldIn.getTileEntity(pos) as TileEntityInjectionTable
			if (!playerIn.isSneaking){
				playerIn.openGui(Core.instance, InjectionTableGuiHandler.INJECTION_TABLE_CONTAINER, worldIn, pos.x, pos.y, pos.z)
			}
			println("aaaaaaa")
		}
		return true
	}
}