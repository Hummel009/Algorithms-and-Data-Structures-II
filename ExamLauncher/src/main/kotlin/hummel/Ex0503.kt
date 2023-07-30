package hummel

import java.io.BufferedWriter
import java.io.IOException
import java.io.OutputStreamWriter
import java.util.*

object Ex0503 {
	private var scan = Scanner(System.`in`)
	private var divider: Short = 10007
	private var base: Short = 47
	private var steps: Short = 6
	private var subStringHashCode = 0
	private var patternLength = 0
	private lateinit var powers: IntArray

	private fun fillPowers() {
		powers = IntArray(patternLength + 1)
		powers[0] = 1
		powers[1] = base.toInt()
		if (patternLength >= 3) {
			for (power in 2 until patternLength) {
				powers[power] = powers[power - 1] * base % divider
			}
		}
	}

	private fun hashCode(pattern: CharArray): Int {
		var hashCode = 0
		for ((power, ch) in pattern.withIndex()) {
			hashCode = ((hashCode + ch.code * powers[power]) % divider + divider) % divider
		}
		return hashCode
	}

	private fun hashCode(text: CharArray, i: Int): Int {
		var hashCode = 0
		if (i != text.size - patternLength) {
			hashCode =
				(subStringHashCode - text[i + patternLength].code * powers[patternLength - 1] % divider + divider) % divider
			hashCode = (hashCode * base + text[i].code) % divider
		} else {
			var power = 0
			var pos = i
			while (pos < i + patternLength) {
				hashCode = (hashCode + text[pos].code * powers[power] % divider) % divider
				pos++
				power++
			}
		}
		return hashCode
	}

	fun launch() {
		val pattern = scan.next().toCharArray()
		val text = scan.next().toCharArray()
		patternLength = pattern.size
		fillPowers()
		val patternHashCode = hashCode(pattern)
		val matches = LinkedList<Int>()
		val writer = BufferedWriter(OutputStreamWriter(System.out))
		for (i in text.size - pattern.size downTo 0) {
			subStringHashCode = hashCode(text, i)
			if (patternHashCode == subStringHashCode) {
				var equals = true
				var pLeft = 0
				var pRight = patternLength - 1
				var tLeft = i
				var tRight = i + pRight
				var steps = 0
				while (tLeft < tRight && steps <= this.steps) {
					if (pattern[pLeft] != text[tLeft] || pattern[pRight] != text[tRight]) {
						equals = false
						break
					}
					pLeft++
					tLeft++
					pRight--
					tRight--
					steps++
				}
				if (equals) {
					matches.addFirst(i)
				}
			}
		}
		for (match in matches) {
			try {
				writer.write(String.format("%s ", match.toString()))
			} catch (e: IOException) {
				e.printStackTrace()
			}
		}
		try {
			writer.close()
		} catch (e: IOException) {
			e.printStackTrace()
		}
	}
}
