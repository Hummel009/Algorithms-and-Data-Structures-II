package hummel

import java.util.*

object Ex0301 {
	private var size = 0
	private lateinit var heap: IntArray
	private var swapCounter = 0
	private var sb = StringBuilder()
	private var scan = Scanner(System.`in`)
	private fun fixHeap() {
		for (i in size / 2 - 1 downTo 0) {
			siftDown(i)
		}
	}

	fun launch() {
		size = scan.nextInt()
		heap = IntArray(size)
		for (i in 0 until size) {
			heap[i] = scan.nextInt()
		}
		fixHeap()
		println(swapCounter)
		if (swapCounter != 0) {
			println(sb.toString())
		}
	}

	private fun siftDown(index: Int) {
		var index = index
		var smallestIndex: Int
		val top = heap[index]
		while (index < size / 2) {
			val leftChildIndex = 2 * index + 1
			val rightChildIndex = leftChildIndex + 1
			smallestIndex = if (rightChildIndex >= size) {
				if (heap[leftChildIndex] > heap[index]) index else leftChildIndex
			} else if (heap[leftChildIndex] > heap[rightChildIndex]) {
				rightChildIndex
			} else {
				leftChildIndex
			}
			if (top <= heap[smallestIndex]) {
				break
			}
			swapCounter++
			sb.append(String.format("%s %s %n", index, smallestIndex))
			heap[index] = heap[smallestIndex]
			index = smallestIndex
			heap[index] = top
		}
	}
}