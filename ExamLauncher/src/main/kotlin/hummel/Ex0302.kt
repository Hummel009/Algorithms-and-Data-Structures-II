package hummel

import java.nio.charset.StandardCharsets
import java.util.*

object Ex0302 {
	fun launch() {
		val scanner = Scanner(System.`in`, StandardCharsets.UTF_8.name())
		val amogus = scanner.nextInt()
		val heap = Heap(amogus)
		val processesCount = scanner.nextInt()
		for (i in 0 until processesCount) {
			val firstFree = heap.firstFree
			System.out.printf("%s %s%n", (firstFree ?: return).number, firstFree.time)
			val newTime = scanner.nextLong()
			if (newTime != 0L) {
				heap.changeTime(newTime)
			}
		}
		scanner.close()
	}

	class Heap(private var size: Int) {
		private var processors: Array<Processor?> = arrayOfNulls(size)

		init {
			for (i in 0 until size) {
				processors[i] = Processor(i, 0)
			}
		}

		fun changeTime(newTime: Long) {
			(processors[0] ?: return).time += newTime
			siftDown(0)
		}

		val firstFree: Processor?
			get() = processors[0]

		private fun siftDown(index: Int) {
			var shadIndex = index
			var smallestIndex: Int
			val top = processors[shadIndex]
			while (shadIndex < size / 2) {
				val leftChildIndex = 2 * shadIndex + 1
				val rightChildIndex = leftChildIndex + 1
				smallestIndex = if (rightChildIndex >= size) {
					if ((processors[leftChildIndex] ?: return).time > (processors[shadIndex]
							?: return).time
					) shadIndex else leftChildIndex
				} else if ((processors[leftChildIndex] ?: return).time > (processors[rightChildIndex] ?: return).time) {
					rightChildIndex
				} else if ((processors[leftChildIndex] ?: return).time == (processors[rightChildIndex]
						?: return).time
				) {
					if ((processors[leftChildIndex] ?: return).number > (processors[rightChildIndex]
							?: return).number
					) rightChildIndex else leftChildIndex
				} else {
					leftChildIndex
				}
				if ((top ?: return).time < (processors[smallestIndex]
						?: return).time || top.time == (processors[smallestIndex]
						?: return).time && top.number <= (processors[smallestIndex] ?: return).number
				) {
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
