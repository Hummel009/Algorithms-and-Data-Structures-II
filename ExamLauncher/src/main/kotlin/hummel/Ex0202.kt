package hummel

import java.nio.charset.StandardCharsets
import java.util.*

object Ex0202 {
	private fun heightCounter(tree: IntArray, index: Int): Int {
		val pValue = tree[index]
		return if (pValue == -1) {
			1
		} else 1 + heightCounter(tree, pValue)
	}

	fun launch() {
		val scanner = Scanner(System.`in`, StandardCharsets.UTF_8.name())
		val length = scanner.nextInt()
		val tree = IntArray(length)
		for (index in 0 until length) {
			tree[index] = scanner.nextInt()
		}
		scanner.close()
		var height = 1
		for (index in tree.indices) {
			height = height.coerceAtLeast(heightCounter(tree, index))
		}
		println(height)
	}
}
