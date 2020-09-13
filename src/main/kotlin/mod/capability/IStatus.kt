package mod.capability

interface IStatus {
	fun getExp(): Int
	fun setExp(exp: Int)
	fun addExp(exp: Int)

	fun getLevel(): Int
	fun setLevel(level: Int)
	fun addLevel(level: Int)

	fun getMp(): Int
	fun setMp(mp: Int)
	fun addMp(mp: Int)

	fun getMaxMp(): Int
	fun setMaxMp(maxmp: Int)
	fun addMaxMp(maxmp: Int)
}