package hummel

import java.util.*

object Ex0601 {
	private lateinit var nodes: Array<Node?>
	private var inOrder = StringBuilder()
	private var preOrder = StringBuilder()
	private var postOrder = StringBuilder()
	private var scan = Scanner(System.`in`)

	fun launch() {
		val vertexCount = scan.nextInt()
		nodes = arrayOfNulls(vertexCount)
		for (i in 0 until vertexCount) {
			nodes[i] = Node(scan.nextInt(), scan.nextInt(), scan.nextInt())
		}
		walk(0)
		println(inOrder.toString())
		println(preOrder.toString())
		println(postOrder.toString())
	}

	private fun walk(index: Int) {
		if (index == -1) {
			return
		}
		preOrder.append(nodes[index]!!.value)
		preOrder.append(" ")
		walk(nodes[index]!!.left)
		inOrder.append(nodes[index]!!.value)
		inOrder.append(" ")
		walk(nodes[index]!!.right)
		postOrder.append(nodes[index]!!.value)
		postOrder.append(" ")
	}

	class Node(var value: Int, var left: Int, var right: Int)
}
