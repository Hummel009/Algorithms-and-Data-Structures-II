package hummel

import java.nio.charset.StandardCharsets
import java.util.*

object Ex0203 {
	private var time = 0
	private var bufferSize = 0
	private var buffer: Deque<Package>? = null

	fun launch() {
		val scanner = Scanner(System.`in`, StandardCharsets.UTF_8.name())
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
		scanner.close()
	}

	private fun process(pack: Package) {
		if ((buffer ?: return).size < bufferSize) {
			println(time.coerceAtLeast(pack.average))
			if (pack.average >= time) {
				time = pack.endTime
			} else {
				time += pack.duration
			}
			pack.end = time
			(buffer ?: return).add(pack)
		} else if (pack.average >= (buffer ?: return).first.end) {
			println(time.coerceAtLeast(pack.average))
			if (time > (buffer ?: return).last.end) {
				time += pack.duration
			} else {
				time = (buffer ?: return).last.end + pack.duration
			}
			(buffer ?: return).removeFirst()
			pack.end = time
			(buffer ?: return).add(pack)
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