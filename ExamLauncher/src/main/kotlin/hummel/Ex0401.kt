package hummel

import java.nio.charset.StandardCharsets
import java.util.*

object Ex0401 {
	fun launch() {
		val scanner = Scanner(System.`in`, StandardCharsets.UTF_8.name())
		val tablesCount = scanner.nextInt()
		val requestsCount = scanner.nextInt()
		val set = Set(tablesCount)
		for (i in 0 until tablesCount) {
			set.initSet(scanner.nextInt(), i)
		}
		for (i in 0 until requestsCount) {
			set.union(scanner.nextInt() - 1, scanner.nextInt() - 1)
			println(set.maxRank)
		}
		scanner.close()
	}

	class Set(tablesCount: Int) {
		private var rank: IntArray
		private var setArray: IntArray
		var maxRank: Int = 0

		init {
			setArray = IntArray(tablesCount)
			rank = IntArray(tablesCount)
		}

		private fun find(i: Int): Int {
			if (i != setArray[i]) {
				setArray[i] = find(setArray[i])
			}
			return setArray[i]
		}

		fun initSet(entryCount: Int, position: Int) {
			setArray[position] = position
			rank[position] = entryCount
			maxRank = entryCount.coerceAtLeast(maxRank)
		}

		fun union(destination: Int, source: Int) {
			val destinationID = find(destination)
			val sourceID = find(source)
			if (destinationID == sourceID) {
				return
			}
			setArray[sourceID] = destinationID
			rank[destinationID] += rank[sourceID]
			maxRank = rank[destinationID].coerceAtLeast(maxRank)
		}
	}
}
