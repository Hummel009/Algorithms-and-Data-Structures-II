package hummel

object Ex0301 {
	private var size = 0
	private var swapCounter = 0
	private var sb = StringBuilder()
	private lateinit var heap: IntArray

	private fun fixHeap() {
		for (i in size / 2 - 1 downTo 0) {
			siftDown(i)
		}
	}

	fun launch() {
		size = scanner.nextInt()
		heap = IntArray(size)
		for (i in 0 until size) {
			heap[i] = scanner.nextInt()
		}
		fixHeap()
		println(swapCounter)
		if (swapCounter != 0) {
			println(sb.toString())
		}
	}

	private fun siftDown(index: Int) {
		var shadIndex = index
		var smallestIndex: Int
		val top = heap[shadIndex]
		while (shadIndex < size / 2) {
			val leftChildIndex = 2 * shadIndex + 1
			val rightChildIndex = leftChildIndex + 1
			smallestIndex = if (rightChildIndex >= size) {
				if (heap[leftChildIndex] > heap[shadIndex]) shadIndex else leftChildIndex
			} else if (heap[leftChildIndex] > heap[rightChildIndex]) {
				rightChildIndex
			} else {
				leftChildIndex
			}
			if (top <= heap[smallestIndex]) {
				break
			}
			swapCounter++
			sb.append(String.format("%s %s %n", shadIndex, smallestIndex))
			heap[shadIndex] = heap[smallestIndex]
			shadIndex = smallestIndex
			heap[shadIndex] = top
		}
	}
}