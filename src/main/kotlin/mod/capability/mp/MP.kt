package mod.capability.mp

class MP : IMP {
	private var MP: Int = 100

	override fun get(): Int {
		return this.MP
	}

	override fun set(mp: Int) {
		this.MP = mp
	}

	override fun add(mp: Int) {
		this.MP += mp
	}
}