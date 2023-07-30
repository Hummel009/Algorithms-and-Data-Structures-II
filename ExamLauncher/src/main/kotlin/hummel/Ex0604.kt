package hummel

import java.util.*

object Ex0604 {
	private var scan = Scanner(System.`in`)

	fun launch() {
		val set = OnlineSet()
		val n = scan.nextInt()
		for (i in 0 until n) {
			when (scan.next()) {
				"+" -> {
					val addNum = scan.nextInt()
					set.add(addNum)
				}

				"-" -> {
					val removeNum = scan.nextInt()
					set.remove(removeNum)
				}

				"?" -> {
					val queryNum = scan.nextInt()
					if (set.contains(queryNum)) {
						println("Found")
					} else {
						println("Not found")
					}
				}

				"s" -> {
					val l = scan.nextInt()
					val r = scan.nextInt()
					println(set.sum(l, r))
				}

				else -> println("Invalid operation")
			}
		}
	}

	class OnlineSet {
		private val set: HashSet<Int> = HashSet()
		private var lastSum: Long = 0

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