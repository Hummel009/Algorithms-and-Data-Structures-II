package hummel

object Ex0604 {
	fun launch() {
		val set = OnlineSet()
		val n = scanner.nextInt()
		for (i in 0 until n) {
			when (scanner.next()) {
				"+" -> {
					val addNum = scanner.nextInt()
					set.add(addNum)
				}

				"-" -> {
					val removeNum = scanner.nextInt()
					set.remove(removeNum)
				}

				"?" -> {
					val queryNum = scanner.nextInt()
					if (set.contains(queryNum)) {
						println("Found")
					} else {
						println("Not found")
					}
				}

				"s" -> {
					val l = scanner.nextInt()
					val r = scanner.nextInt()
					println(set.sum(l, r))
				}

				else -> println("Invalid operation")
			}
		}
	}

	class OnlineSet {
		private val set = HashSet<Int>()
		private var lastSum = 0L

		fun add(i: Int) {
			val f = ((i + lastSum) % 1000000001).toInt()
			set.add(f)
		}

		operator fun contains(i: Int): Boolean {
			val f = ((i + lastSum) % 1000000001).toInt()
			return set.contains(f)
		}

		fun remove(i: Int) {
			val f = ((i + lastSum) % 1000000001).toInt()
			set.remove(f)
		}

		fun sum(l: Int, r: Int): Long {
			val fL = ((l + lastSum) % 1000000001).toInt()
			val fR = ((r + lastSum) % 1000000001).toInt()
			var sum: Long = 0
			for (i in fL..fR) {
				if (set.contains(i)) {
					sum += i.toLong()
				}
			}
			lastSum += sum
			return sum
		}
	}
}