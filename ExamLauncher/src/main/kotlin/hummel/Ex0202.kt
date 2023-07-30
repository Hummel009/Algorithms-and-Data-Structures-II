package hummel

import java.util.*

object Ex0202 {
	private var scan = Scanner(System.`in`)

	private fun heightCounter(tree: IntArray, index: Int): Int {
		val pValue = tree[index]
		return if (pValue == -1) {
			1
		} else 1 + heightCounter(tree, pValue)
	}

	fun launch() {
		val length = scan.nextInt()
		val tree = IntArray(length)
		for (index in 0 until length) {
			tree[index] = scan.nextInt()
		}
		var height = 1
		for (index in tree.indices) {
			height = Math.max(height, heightCounter(tree, index))
		}
		println(height)
	}
}
