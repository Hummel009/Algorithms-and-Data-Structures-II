package hummel

import java.util.*

object Ex0203 {
	private var time = 0
	private var bufferSize = 0
	private var buffer: Deque<Package>? = null
	private var scan = Scanner(System.`in`)

	fun launch() {
		bufferSize = scan.nextInt()
		buffer = ArrayDeque(bufferSize)
		val packageCount = scan.nextInt()
		if (packageCount == 0) {
			println()
		} else if (packageCount == 1) {
			println(scan.nextInt())
		} else {
			for (i in 0 until packageCount) {
				process(Package(scan.nextInt(), scan.nextInt()))
			}
			scan.close()
		}
	}

	private fun process(pack: Package) {
		if (buffer!!.size < bufferSize) {
			println(time.coerceAtLeast(pack.average))
			if (pack.average >= time) {
				time = pack.endTime
			} else {
				time += pack.duration
			}
			pack.end = time
			buffer!!.add(pack)
		} else if (pack.average >= buffer!!.first.end) {
			println(time.coerceAtLeast(pack.average))
			if (time > buffer!!.last.end) {
				time += pack.duration
			} else {
				time = buffer!!.last.end + pack.duration
			}
			buffer!!.removeFirst()
			pack.end = time
			buffer!!.add(pack)
		} else {
			println("-1")
		}
	}

	class Package(var average: Int, var duration: Int) {
		var end = 0
		val endTime: Int
			get() = average + duration
	}
}