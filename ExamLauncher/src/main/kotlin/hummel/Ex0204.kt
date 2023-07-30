package hummel

import java.util.*
import kotlin.math.max

object Ex0204 {
	private var scan = Scanner(System.`in`)

	fun launch() {
		val operationCount = scan.nextInt()
		val operationStack: Deque<Int> = ArrayDeque(operationCount)
		val maxStack: Deque<Int> = ArrayDeque(operationCount)
		for (i in 0 until operationCount) {
			val operation: String = scan.next()
			if (operation.startsWith("push")) {
				val value: Int = scan.nextInt()
				operationStack.push(value)
				maxStack.push(max(if (maxStack.isEmpty()) 0 else maxStack.peek(), value))
			} else if (operation.startsWith("pop")) {
				operationStack.pop()
				maxStack.pop()
			} else {
				println(if (maxStack.isEmpty()) 0 else maxStack.peek())
			}
		}
	}
}