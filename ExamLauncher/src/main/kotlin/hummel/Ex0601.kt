package hummel

import java.nio.charset.StandardCharsets
import java.util.*

object Ex0601 {
	private lateinit var nodes: Array<Node?>
	private var inOrder = StringBuilder()
	private var preOrder = StringBuilder()
	private var postOrder = StringBuilder()

	fun launch() {
		val scanner = Scanner(System.`in`, StandardCharsets.UTF_8.name())
		val vertexCount = scanner.nextInt()
		nodes = arrayOfNulls(vertexCount)
		for (i in 0 until vertexCount) {
			nodes[i] = Node(scanner.nextInt(), scanner.nextInt(), scanner.nextInt())
		}
		scanner.close()
		walk(0)
		println(inOrder.toString())
		println(preOrder.toString())
		println(postOrder.toString())
	}

	private fun walk(index: Int) {
		if (index == -1) {
			return
		}
		preOrder.append((nodes[index] ?: return).value)
		preOrder.append(" ")
		walk((nodes[index] ?: return).left)
		inOrder.append((nodes[index] ?: return).value)
		inOrder.append(" ")
		walk((nodes[index] ?: return).right)
		postOrder.append((nodes[index] ?: return).value)
		postOrder.append(" ")
	}

	class Node(var value: Int, var left: Int, var right: Int)
}
