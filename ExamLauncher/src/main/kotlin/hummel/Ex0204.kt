package hummel

import java.nio.charset.StandardCharsets
import java.util.*
import kotlin.math.max

object Ex0204 {
	fun launch() {
		val scanner = Scanner(System.`in`, StandardCharsets.UTF_8.name())
		val operationCount = scanner.nextInt()
		val operationStack: Deque<Int> = ArrayDeque(operationCount)
		val maxStack: Deque<Int> = ArrayDeque(operationCount)
		for (i in 0 until operationCount) {
			val operation: String = scanner.next()
			if (operation.startsWith("push")) {
				val value: Int = scanner.nextInt()
				operationStack.push(value)
				maxStack.push(max(if (maxStack.isEmpty()) 0 else maxStack.peek(), value))
			} else if (operation.startsWith("pop")) {
				operationStack.pop()
				maxStack.pop()
			} else {
				println(if (maxStack.isEmpty()) 0 else maxStack.peek())
			}
		}
		scanner.close()
	}
}