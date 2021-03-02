package mod.capability

class Mp: IMp{
	private var mp: Int = 100

	override fun getMp(): Int {
		return mp
	}

	override fun setMp(value: Int) {
		mp = value
	}

	override fun addMp(value: Int) {
		mp += value
	}

	override fun useMp(value: Int) {
		mp -= value
	}
}