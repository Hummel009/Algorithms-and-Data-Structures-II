package hummel

object Ex0401 {
	fun launch() {
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
	}

	class Set(tablesCount: Int) {
		private var rank = IntArray(tablesCount)
		private var setArray = IntArray(tablesCount)
		var maxRank: Int = 0

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
