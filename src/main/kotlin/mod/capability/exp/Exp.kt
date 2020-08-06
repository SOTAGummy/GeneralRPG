package mod.capability.exp

class Exp: IExp {
    private var Exp: Int = 0

    override fun get(): Int {
        return this.Exp
    }

    override fun set(exp: Int) {
        this.Exp = exp
    }

    override fun add(exp: Int) {
        this.Exp += exp
    }
}