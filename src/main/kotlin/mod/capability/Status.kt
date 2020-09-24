package mod.capability

class Status: IStatus{
	private var EXP = 0
	private var LEVEL = 1
	private var MP = 100
	private var MAXMP = 100

	override fun getExp(): Int {
		return EXP
	}

	override fun setExp(exp: Int) {
		EXP = exp
	}

	override fun addExp(exp: Int) {
		EXP += exp
	}

	//----------------------------------------

	override fun getLevel(): Int {
		return LEVEL
	}

	override fun setLevel(level: Int) {
		LEVEL = level
	}

	override fun addLevel(level: Int) {
		LEVEL += level
	}

	//----------------------------------------

	override fun getMp(): Int {
		return MP
	}

	override fun setMp(mp: Int) {
		MP = mp
	}

	override fun addMp(mp: Int) {
		if (MP + mp > MAXMP){
			MP = MAXMP
		}else{
			MP += mp
		}
	}

	//----------------------------------------

	override fun getMaxMp(): Int {
		return MAXMP
	}

	override fun setMaxMp(maxmp: Int) {
		MAXMP = maxmp
	}

	override fun addMaxMp(maxmp: Int) {
		MAXMP += maxmp
	}
}