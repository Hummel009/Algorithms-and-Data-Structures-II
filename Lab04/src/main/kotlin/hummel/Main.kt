package hummel

import java.util.*
import kotlin.math.max

fun main() {
	// Ask user to enter number of nodes
	print("Enter number of nodes: ")
	val n = readIntSafe()

	println()

	val adjMatrix = Array(n) { i ->
		IntArray(n) { j ->
			if (i != j) {
				print("Write the weight for connection: ${i + 1} -> ${j + 1}: ")
				readIntSafe()
			} else {
				0
			}
		}
	}
	println()

	// Print distances in graph as a table
	println("Adjustment matrix:")
	println("\n |${adjMatrix.indices.joinToString("|") { "_${it + 1}_" }}")
	adjMatrix.indices.forEach { i -> println("${i + 1}| " + adjMatrix[i].joinToString(" | ")) }
	println()

	// Ask user to enter start and end nodes
	print("Enter a way from: ")
	val startNode = readIntSafeRange(adjMatrix.indices) - 1
	print("Enter a way to: ")
	val endNode = readIntSafeRange(adjMatrix.indices) - 1

	println()

	// Find all ways from start node to end node
	val visited = BooleanArray(n)
	val ways = mutableListOf<List<Int>>()
	dfs(startNode, endNode, visited, mutableListOf(startNode), ways, adjMatrix)
	if (ways.isEmpty()) {
		println("No ways found.")
		return
	}

	// Print all ways from start node to end node
	println("Ways from node $startNode to node $endNode:")
	ways.map { it.map { node -> node + 1 } }.forEach { println(it.joinToString(" -> ")) }
	println()

	// Calculate max and min ways from start node to end node
	val lengths = ways.map { path ->
		path.foldIndexed(0) { i, acc, curr ->
			if (i == 0) acc else acc + adjMatrix[path[i - 1]][curr]
		}
	}
	val maxLength = lengths.maxOrNull()
	val minLength = lengths.minOrNull()
	println("Min way length: $minLength")
	println("Max way length: $maxLength")

	// Calculate graph center
	val distances = Array(n) { IntArray(n) { Int.MAX_VALUE } }
	(0 until n).forEach { bfs(it, adjMatrix, distances) }

	val centers = getCenters(distances).map { it + 1 }
	println("Centers: $centers")
}

fun getCenters(distances: Array<IntArray>): Set<Int> {
	val numVertices = distances.size
	val centers = mutableSetOf<Int>()

	for (i in 0 until numVertices) {
		var maxDist = Int.MIN_VALUE

		(0 until numVertices).filter { i != it }.forEach { maxDist = max(maxDist, distances[i][it]) }

		val isCenter = (0 until numVertices).none { i != it && distances[i][it] > maxDist }

		if (isCenter) {
			centers.add(i)
		}
	}

	return centers
}

fun dfs(
	curr: Int,
	end: Int,
	visited: BooleanArray,
	path: MutableList<Int>,
	ways: MutableList<List<Int>>,
	adjMatrix: Array<IntArray>
) {
	visited[curr] = true
	if (curr == end) {
		ways.add(path.toList())
	} else {
		for (i in adjMatrix[curr].indices) {
			if (adjMatrix[curr][i] != 0 && !visited[i]) {
				path.add(i)
				dfs(i, end, visited, path, ways, adjMatrix)
				path.removeAt(path.lastIndex)
			}
		}
	}
	visited[curr] = false
}

fun bfs(start: Int, adjMatrix: Array<IntArray>, distances: Array<IntArray>) {
	val queue = LinkedList<Int>()
	queue.offer(start)
	distances[start][start] = 0
	while (queue.isNotEmpty()) {
		val curr = queue.poll()
		for (i in adjMatrix[curr].indices) {
			if (adjMatrix[curr][i] != 0 && distances[start][i] == Int.MAX_VALUE) {
				distances[start][i] = distances[start][curr] + adjMatrix[curr][i]
				queue.offer(i)
			}
		}
	}
}

fun readIntSafe(): Int {
	return try {
		readln().toInt()
	} catch (e: Exception) {
		print("Error! Enter the correct value: ")
		readIntSafe()
	}
}

fun readIntSafeRange(range: IntRange): Int {
	return try {
		val num = readln().toInt()
		if (num - 1 !in range) {
			throw Exception()
		}
		num
	} catch (e: Exception) {
		print("Error! Enter the correct value: ")
		readIntSafeRange(range)
	}
}