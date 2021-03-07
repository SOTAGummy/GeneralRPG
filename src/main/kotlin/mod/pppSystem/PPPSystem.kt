package mod.pppSystem

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.TickEvent

object PPPSystem {
	private val processTree: MutableMap<String, ArrayList<IFunctionOperator?>> = mutableMapOf()
	private val idList: ArrayList<String> = arrayListOf()
	private val mainProcess: ArrayList<IFunctionOperator?> = arrayListOf()

	fun addDelay(id: String, count: Int){
		if (id == "main"){
			repeat(count){
				mainProcess.add(null)
			}
		} else {
			if (processTree[id] != null){
				repeat(count){
					processTree[id]?.add(null)
				}
			}
		}
	}

	fun addProcess(id: String, function: IFunctionOperator?) {
		if (id == "main") {
			mainProcess.add(function)
		} else {
			if (processTree[id] != null){
				processTree[id]?.add(function)
			}
		}
	}

	fun launchNewThread(id: String){
		processTree[id] = arrayListOf()
		idList.add(id)
	}

	@SubscribeEvent
	fun tickEvent(event: TickEvent.WorldTickEvent) {
		if (mainProcess.isNotEmpty()){
			val obj = mainProcess[0]
			if (obj == null){
				mainProcess.removeAt(0)
			} else {
				obj.call(obj.world, obj.player, obj.hand)
				if(mainProcess.isNotEmpty()) mainProcess.removeAt(0)
			}
		}

		repeat(processTree.size){
			if (processTree[idList[it]] != null && processTree[idList[it]]?.isNotEmpty()!!){
				val obj = processTree[idList[it]]?.get(0)
				if (obj == null){
					processTree[idList[it]]?.removeAt(0)
				} else {
					obj.call(obj.world, obj.player, obj.hand)
					if (processTree[idList[it]]?.isNotEmpty()!!) processTree[idList[it]]?.removeAt(0)
				}
			}
		}
	}
}