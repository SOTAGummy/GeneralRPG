package mod.util

fun Int.percent(denominator: Int): Int {
	return ((this.toFloat() / denominator.toFloat()).toInt() + 1) * 100
}