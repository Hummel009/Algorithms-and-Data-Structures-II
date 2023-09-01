package hummel

object Ex0205 {
	private fun getMaxValueIndex(values: IntArray, startPos: Int, endPos: Int): Int {
		var maxValueIndex = startPos
		for (i in startPos..endPos) {
			maxValueIndex = if (values[i] > values[maxValueIndex]) i else maxValueIndex
		}
		return maxValueIndex
	}

	fun launch() {
		val valuesCount = scanner.nextInt()
		val values = IntArray(valuesCount)
		for (i in 0 until valuesCount) {
			values[i] = scanner.nextInt()
		}
		val windowSize = scanner.nextInt()
		if (valuesCount == windowSize) {
			println(values[getMaxValueIndex(values, 0, values.size - 1)])
		} else if (windowSize == 1) {
			val stringBuilder = StringBuilder()
			for (element in values) {
				stringBuilder.append(element)
				stringBuilder.append(" ")
			}
			println(stringBuilder)
		} else {
			var left = 0
			var right = windowSize - 1
			var maxValueIndex = getMaxValueIndex(values, left, right)
			val stringBuilder = StringBuilder()
			while (right < values.size) {
				if (left > maxValueIndex) {
					maxValueIndex = getMaxValueIndex(values, left, right)
				}
				if (values[right] > values[maxValueIndex]) {
					maxValueIndex = right
				}
				stringBuilder.append(values[maxValueIndex])
				stringBuilder.append(" ")
				left++
				right++
			}
			println(stringBuilder)
		}
	}
}
