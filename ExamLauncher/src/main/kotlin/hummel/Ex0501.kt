package hummel

import java.util.*

object Ex0501 {
	private var scan = Scanner(System.`in`)

	fun launch() {
		val operationCount = scan.nextInt()
		val table = arrayOfNulls<String>(10000000)
		for (i in 0 until operationCount) {
			val operation = scan.next()
			val number = scan.nextInt()
			if (operation.startsWith("a")) {
				table[number] = scan.next()
			} else if (operation.startsWith("f")) {
				println(if (table[number] == null) "not found" else table[number])
			} else {
				table[number] = null
			}
		}
	}
}
