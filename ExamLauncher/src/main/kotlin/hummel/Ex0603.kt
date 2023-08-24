package hummel

import java.nio.charset.StandardCharsets
import java.util.*

object Ex0603 {
	private lateinit var nodes: Array<Node?>

	private fun isTreeValid(index: Int, range: Range): Boolean {
		if (index == -1) {
			return true
		}
		range.left = nodes[index]!!.value
		range.right = nodes[index]!!.value
		if (nodes[index]!!.left != -1) {
			val lRange = Range(0, 0)
			if (!isTreeValid(nodes[index]!!.left, lRange) || lRange.right > nodes[index]!!.value) {
				return false
			}
			range.left = lRange.left
		}
		if (nodes[index]!!.right != -1) {
			val rRange = Range(0, 0)
			if (!isTreeValid(nodes[index]!!.right, rRange) || rRange.left <= nodes[index]!!.value) {
				return false
			}
			range.right = rRange.right
		}
		return true
	}

	fun launch() {
		val scanner = Scanner(System.`in`, StandardCharsets.UTF_8.name())
		val vertexCount = scanner.nextInt()
		if (vertexCount == 0) {
			println("CORRECT")
		} else {
			nodes = arrayOfNulls(vertexCount)
			for (i in 0 until vertexCount) {
				nodes[i] = Node(scanner.nextLong(), scanner.nextInt(), scanner.nextInt())
			}
			val range = Range(0, 0)
			println(if (isTreeValid(0, range)) "CORRECT" else "INCORRECT")
		}
		scanner.close()
	}

	class Node(var value: Long, var left: Int, var right: Int)
	class Range(var left: Long, var right: Long)
}
