package hummel

object Ex0501 {
	fun launch() {
		val operationCount = scanner.nextInt()
		val table = arrayOfNulls<String>(10000000)
		for (i in 0 until operationCount) {
			val operation = scanner.next()
			val number = scanner.nextInt()
			if (operation.startsWith("a")) {
				table[number] = scanner.next()
			} else if (operation.startsWith("f")) {
				println(if (table[number] == null) "not found" else table[number])
			} else {
				table[number] = null
			}
		}
	}
}
