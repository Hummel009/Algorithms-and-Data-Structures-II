package hummel

import java.util.*

object Ex0203 {
	private var time = 0
	private var bufferSize = 0
	private lateinit var buffer: Deque<Package>

	fun launch() {
		bufferSize = scanner.nextInt()
		buffer = ArrayDeque(bufferSize)
		when (val packageCount = scanner.nextInt()) {
			0 -> println()
			1 -> println(scanner.nextInt())
			else -> {
				for (i in 0 until packageCount) {
					process(Package(scanner.nextInt(), scanner.nextInt()))
				}
			}
		}
	}

	private fun process(pack: Package) {
		if (buffer.size < bufferSize) {
			println(time.coerceAtLeast(pack.average))
			if (pack.average >= time) {
				time = pack.endTime
			} else {
				time += pack.duration
			}
			pack.end = time
			buffer.add(pack)
		} else if (pack.average >= buffer.first.end) {
			println(time.coerceAtLeast(pack.average))
			if (time > buffer.last.end) {
				time += pack.duration
			} else {
				time = buffer.last.end + pack.duration
			}
			buffer.removeFirst()
			pack.end = time
			buffer.add(pack)
		} else {
			println("-1")
		}
	}

	class Package(var average: Int, var duration: Int) {
		var end: Int = 0
		val endTime: Int
			get() = average + duration
	}
}