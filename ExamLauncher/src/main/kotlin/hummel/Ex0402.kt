package hummel

import java.util.*

object Ex0402 {
	var scan: Scanner = Scanner(System.`in`)

	fun launch() {
		val maxNumber = scan.nextInt()
		val numberOfEqualities = scan.nextInt()
		val numberOfInequalities = scan.nextInt()
		val set = Set(maxNumber)
		var result = 1
		for (i in 0 until numberOfEqualities) {
			set.union(scan.nextInt() - 1, scan.nextInt() - 1)
		}
		for (i in 0 until numberOfInequalities) {
			if (set.check(scan.nextInt() - 1, scan.nextInt() - 1)) {
				result = 0
				break
			}
		}
		println(result)
	}

	class Set(size: Int) {
		private var setArray: IntArray

		init {
			setArray = IntArray(size)
			for (i in 0 until size) {
				setArray[i] = i
			}
		}

		fun check(left: Int, right: Int): Boolean {
			return setArray[find(left)] == setArray[find(right)]
		}

		private fun find(i: Int): Int {
			if (i != setArray[i]) {
				setArray[i] = find(setArray[i])
			}
			return setArray[i]
		}

		fun union(destination: Int, source: Int) {
			val destinationID = find(destination)
			val sourceID = find(source)
			setArray[sourceID] = destinationID
		}
	}
}
