package hummel

import java.util.*
import kotlin.math.max

object Ex0204 {
	fun launch() {
		val operationCount = scanner.nextInt()
		val operationStack = ArrayDeque<Int>(operationCount)
		val maxStack = ArrayDeque<Int>(operationCount)
		for (i in 0 until operationCount) {
			val operation = scanner.next()
			if (operation.startsWith("push")) {
				val value = scanner.nextInt()
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