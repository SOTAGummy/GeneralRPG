package mod.capability.maxmp

class MaxMP: IMaxMP{
	private var MaxMP = 100

	override fun get(): Int {
		return this.MaxMP
	}

	override fun set(max_mp: Int) {
		this.MaxMP= max_mp
	}

	override fun add(max_mp: Int) {
		this.MaxMP += max_mp
	}
}