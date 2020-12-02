package PPPSystem

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.TickEvent

object PPPSystem{
	private val processArray: ArrayList<UniqueBinaryOperator?> = arrayListOf()

	fun addProcess(function: UniqueBinaryOperator){
		this.processArray.add(function)
	}

	fun insertProcess(function: UniqueBinaryOperator?){
		val alter: ArrayList<UniqueBinaryOperator?> = processArray
		this.processArray[0] = function
		processArray.plus(alter)
	}

	fun addDelay(delay: Int){
		repeat(delay){
			this.processArray.add(null)
		}
	}

	private fun shiftArray(list: ArrayList<UniqueBinaryOperator?>) {
		if (list.size == 1){
			list.clear()
		} else {
			repeat(list.size - 1) {
				list[it] = list[it + 1]
			}
			list.removeAt(list.size - 1)
		}
	}

	@SubscribeEvent
	fun tickEvent(event: TickEvent.WorldTickEvent) {
		if (processArray.isNotEmpty()){
			if (processArray[0] is UniqueBinaryOperator){
				val func = processArray[0]!!
				func.call(func.World, func.Player, func.Hand)
				shiftArray(processArray)
			} else if (processArray[0] == null){
				shiftArray(processArray)
			}
		}
	}
}