package mod.block

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraftforge.fml.common.network.IGuiHandler


open class InjectionTableGuiHandler : IGuiHandler {
	companion object {
		const val INJECTION_TABLE_CONTAINER = 1
	}

	override fun getClientGuiElement(ID: Int, player: EntityPlayer?, world: World?, x: Int, y: Int, z: Int): Any? {
		return if (ID == INJECTION_TABLE_CONTAINER) {
			InjectionTableContainer(player?.inventory!!, world!!.getTileEntity(BlockPos(x, y, z)) as TileEntityInjectionTable)
		} else null
	}

	override fun getServerGuiElement(ID: Int, player: EntityPlayer?, world: World?, x: Int, y: Int, z: Int): Any? {
		return if (ID == INJECTION_TABLE_CONTAINER) {
			InjectionTableGui(player?.inventory!!, world!!.getTileEntity(BlockPos(x, y, z)) as TileEntityInjectionTable)
		} else null
	}
}