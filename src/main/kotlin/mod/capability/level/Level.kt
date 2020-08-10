package mod.capability.level

class Level : ILevel {
	private var Level: Int = 1

	override fun get(): Int {
		return this.Level
	}

	override fun set(level: Int) {
		this.Level = level
	}

	override fun add() {
		this.Level += 1
	}
}