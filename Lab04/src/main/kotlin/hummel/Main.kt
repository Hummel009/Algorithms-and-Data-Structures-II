package hummel

import java.nio.charset.StandardCharsets
import java.util.*
import kotlin.math.max

fun main() {
	var n: Int
	var adjMatrix: Array<IntArray>
	var startNode: Int
	var endNode: Int
	Scanner(System.`in`, StandardCharsets.UTF_8.name()).use {
		// Ask user to enter number of nodes
		print("Enter number of nodes:")
		n = it.nextIntSafe()

		println()

		// Initialize adjacency matrix for graph
		adjMatrix = Array(n) { IntArray(n) }

		// Ask user to enter weights for every connection between every node
		for (i in adjMatrix.indices) {
			for (j in adjMatrix[i].indices) {
				if (i != j) {
					print("Write the weight for connection: ${i + 1} -> ${j + 1}:")
					adjMatrix[i][j] = it.nextIntSafe()
				}
			}
		}
		println()

		// Print distances in graph as a table
		println("Adjustment matrix:")
		print("\n |")
		for (k in adjMatrix.indices) {
			System.out.printf("__%d_|", k + 1)
		}
		println()
		for (i in adjMatrix.indices) {
			print("${i + 1}|")
			for (j in adjMatrix.indices) {
				print(" ${adjMatrix[i][j].toString().padStart(2, ' ')} |")
			}
			println()
		}
		println()

		// Ask user to enter start and end nodes
		print("Enter a way from:")
		startNode = it.nextIntSafeRange(adjMatrix.indices) - 1
		print("Enter a way to:")
		endNode = it.nextIntSafeRange(adjMatrix.indices) - 1
	}

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
	for (way in ways) {
		val nodeValues = way.map { node -> node + 1 }
		println(nodeValues.joinToString(" -> "))
	}
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
	for (i in 0 until n) {
		bfs(i, adjMatrix, distances)
	}

	val centers = getCenters(distances).map { it + 1 }
	println("Centers: $centers")
}

fun getCenters(distances: Array<IntArray>): Set<Int> {
	val numVertices = distances.size
	val centers = mutableSetOf<Int>()

	for (i in 0 until numVertices) {
		var maxDist = Int.MIN_VALUE

		for (j in 0 until numVertices) {
			if (i == j) {
				continue
			}

			maxDist = max(maxDist, distances[i][j])
		}

		var isCenter = true

		for (j in 0 until numVertices) {
			if (i == j) {
				continue
			}

			if (distances[i][j] > maxDist) {
				isCenter = false
				break
			}
		}

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

fun Scanner.nextIntSafe(): Int {
	return try {
		nextLine().toInt()
	} catch (e: Exception) {
		print("Error! Enter the correct value:")
		nextIntSafe()
	}
}

fun Scanner.nextIntSafeRange(diapason: IntRange): Int {
	return try {
		val int = this.nextLine().toInt()
		if (int - 1 !in diapason) {
			throw Exception()
		}
		int
	} catch (e: Exception) {
		print("Error! Enter the correct value:")
		nextIntSafeRange(diapason)
	}
}