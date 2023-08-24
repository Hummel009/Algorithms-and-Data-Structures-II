package hummel

import java.nio.charset.StandardCharsets
import java.util.*

object Ex0602 {
	private lateinit var nodes: Array<Node?>

	private fun isTreeValid(index: Int, leftBorder: Int, rightBorder: Int): Boolean {
		if (index == -1) {
			return true
		}
		return if (nodes[index]!!.value < leftBorder || nodes[index]!!.value > rightBorder) {
			false
		} else isTreeValid(
			nodes[index]!!.left,
			leftBorder,
			nodes[index]!!.value
		) && isTreeValid(
			nodes[index]!!.right, nodes[index]!!.value, rightBorder
		)
	}

	fun launch() {
		val scanner = Scanner(System.`in`, StandardCharsets.UTF_8.name())
		val vertexCount = scanner.nextInt()
		if (vertexCount != 0) {
			nodes = arrayOfNulls(vertexCount)
			for (i in 0 until vertexCount) {
				nodes[i] = Node(scanner.nextInt(), scanner.nextInt(), scanner.nextInt())
			}
			println(if (isTreeValid(0, Int.MIN_VALUE, Int.MAX_VALUE)) "CORRECT" else "INCORRECT")
		} else {
			println("CORRECT")
		}
		scanner.close()
	}

	class Node(var value: Int, var left: Int, var right: Int)
}