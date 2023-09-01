package hummel

object Ex0202 {
	private fun heightCounter(tree: IntArray, index: Int): Int {
		return if (tree[index] == -1) 1 else 1 + heightCounter(tree, tree[index])
	}

	fun launch() {
		val length = scanner.nextInt()
		val tree = IntArray(length)
		for (index in 0 until length) {
			tree[index] = scanner.nextInt()
		}
		var height = 1
		for (index in tree.indices) {
			height = height.coerceAtLeast(heightCounter(tree, index))
		}
		println(height)
	}
}
