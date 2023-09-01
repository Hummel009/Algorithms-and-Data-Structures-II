package hummel

object Ex0602 {
	private lateinit var nodes: Array<Node?>

	private fun isTreeValid(index: Int, leftBorder: Int, rightBorder: Int): Boolean {
		if (index == -1) {
			return true
		}
		nodes[index]?.let {
			return if (it.value < leftBorder || it.value > rightBorder) false
			else isTreeValid(it.left, leftBorder, it.value) && isTreeValid(it.right, it.value, rightBorder)
		}
		return false
	}

	fun launch() {
		val vertexCount = scanner.nextInt()
		if (vertexCount != 0) {
			nodes = Array(vertexCount) {
				Node(scanner.nextInt(), scanner.nextInt(), scanner.nextInt())
			}
			println(if (isTreeValid(0, Int.MIN_VALUE, Int.MAX_VALUE)) "CORRECT" else "INCORRECT")
		} else {
			println("CORRECT")
		}
	}

	class Node(var value: Int, var left: Int, var right: Int)
}