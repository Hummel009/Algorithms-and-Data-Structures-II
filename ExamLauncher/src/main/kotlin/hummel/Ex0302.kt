package hummel

object Ex0302 {
	fun launch() {
		val amogus = scanner.nextInt()
		val heap = Heap(amogus)
		val processesCount = scanner.nextInt()
		for (i in 0 until processesCount) {
			val firstFree = heap.firstFree
			System.out.printf("%s %s%n", firstFree.number, firstFree.time)
			val newTime = scanner.nextLong()
			if (newTime != 0L) {
				heap.changeTime(newTime)
			}
		}
	}

	class Heap(private var size: Int) {
		private val processors = Array(size) { i -> Processor(i, 0) }

		fun changeTime(newTime: Long) {
			processors[0].time += newTime
			siftDown(0)
		}

		val firstFree: Processor
			get() = processors[0]

		private fun siftDown(index: Int) {
			var shadIndex = index
			var smallestIndex: Int
			val top = processors[shadIndex]
			while (shadIndex < size / 2) {
				val leftChildIndex = 2 * shadIndex + 1
				val rightChildIndex = leftChildIndex + 1
				smallestIndex = if (rightChildIndex >= size) {
					if (processors[leftChildIndex].time > processors[shadIndex].time) shadIndex else leftChildIndex
				} else if (processors[leftChildIndex].time > processors[rightChildIndex].time) {
					rightChildIndex
				} else if (processors[leftChildIndex].time == processors[rightChildIndex].time) {
					if (processors[leftChildIndex].number > processors[rightChildIndex].number) rightChildIndex else leftChildIndex
				} else {
					leftChildIndex
				}
				if (top.time < processors[smallestIndex].time || top.time == processors[smallestIndex].time && top.number <= processors[smallestIndex].number) {
					break
				}
				processors[shadIndex] = processors[smallestIndex]
				shadIndex = smallestIndex
				processors[shadIndex] = top
			}
		}
	}

	class Processor(var number: Int, var time: Long)
}
