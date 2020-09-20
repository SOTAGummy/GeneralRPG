package mod.block

import mod.Core
import mod.entity.AnimateItem
import mod.item.baseitem.ItemSkill
import mod.item.baseitem.ItemSkillContainer
import mod.util.WorldUtil
import net.minecraft.block.Block
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
import java.util.*


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

	override fun onBlockActivated(world: World, pos: BlockPos?, state: IBlockState?, player: EntityPlayer?, hand: EnumHand?, side: EnumFacing?, hitX: Float, hitY: Float, hitZ: Float): Boolean {
		val te = world.getTileEntity(pos) as TileEntityInjectionTable
		val stack = player!!.getHeldItem(hand)
		if (!world.isRemote) {
			if (stack.item is ItemSkill){
				te.setSkill(Item.getIdFromItem(stack.item))
				val entity = AnimateItem(world, pos!!.x.toDouble() + 0.5, pos.y.toDouble() + 1, pos.z.toDouble() + 0.5, ItemStack(Item.getItemById(te.getSkill())), ItemStack(Item.getItemById(te.getSkill())).displayName)
				world.spawnEntity(entity)
				te.setUUID(entity.uniqueID)
				stack.count--
				player.setHeldItem(hand, stack)
			} else if (stack.item is ItemSkillContainer){
				if (te.getSkill() != 0){
					if (stack.tagCompound == null){
						val nbt = NBTTagCompound()
						stack.tagCompound = nbt
						println("a")
					}
					if (stack.tagCompound != null){
						println("b")
						repeat((stack.item as ItemSkillContainer).capacity){
							if (stack.tagCompound!!.getInteger("${it + 1}") == 0){
								stack.tagCompound!!.setInteger("${it + 1}", te.getSkill())
								te.setSkill(0)
								if (WorldUtil().getEntityFromUUID(world, te.getUUID()!!) != null)
								world.removeEntity(WorldUtil().getEntityFromUUID(world, te.getUUID()!!))
								te.setUUID(null)
							}
						}
					}
				}
			}
		}
		return true
	}

	override fun createNewTileEntity(worldIn: World, meta: Int): TileEntity? {
		return TileEntityInjectionTable()
	}

	override fun breakBlock(world: World, pos: BlockPos?, state: IBlockState?) {
		val te = world.getTileEntity(pos) as TileEntityInjectionTable
		if (te.getUUID() != null){
			val entity = WorldUtil().getEntityFromUUID(world, te.getUUID()!!)
			world.removeEntity(entity)
			val item = ItemStack(Item.getItemById(te.getSkill()))
			world.spawnEntity(EntityItem(world, pos!!.x.toDouble(), pos.y.toDouble(), pos.z.toDouble(), item))
		}
		super.breakBlock(world, pos!!, state as IBlockState)
	}
}