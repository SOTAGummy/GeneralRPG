package mod.capability

class Mp: IMp{
	var mpValue: Int = 100

	override fun getMp(): Int {
		return mpValue
	}

	override fun setMp(value: Int) {
	 this.mpValue = value
	}

	override fun addMp(value: Int) {
		this.mpValue += value
	}

	override fun useMp(value: Int) {
		this.mpValue -= value
	}
}