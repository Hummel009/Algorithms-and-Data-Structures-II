package hummel

import java.util.*

object Ex0401 {
	private var scan = Scanner(System.`in`)

	fun launch() {
		val tablesCount = scan.nextInt()
		val requestsCount = scan.nextInt()
		val set = Set(tablesCount)
		for (i in 0 until tablesCount) {
			set.initSet(scan.nextInt(), i)
		}
		for (i in 0 until requestsCount) {
			set.union(scan.nextInt() - 1, scan.nextInt() - 1)
			println(set.maxRank)
		}
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
