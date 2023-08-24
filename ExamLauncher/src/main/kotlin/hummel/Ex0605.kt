package hummel

import java.nio.charset.StandardCharsets
import java.util.*

object Ex0605 {
	fun launch() {
		val scanner = Scanner(System.`in`, StandardCharsets.UTF_8.name())
		println("Enter text:")
		val text = scanner.nextLine()
		println("Enter args count:")
		val argsCount = scanner.nextInt()
		scanner.nextLine()
		val rope = Rope(text)
		for (i in 0 until argsCount) {
			val arg = scanner.nextLine()
			val from = arg.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[0].toInt()
			val until = arg.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1].toInt()
			val instead = arg.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[2].toInt()
			val res = rope.ropeText(from, until, instead)
			println(res)
		}
		scanner.close()
	}

	class Rope(private var text: String) {
		fun ropeText(from: Int, until: Int, instead: Int): String {
			val tmp = StringBuilder()
			for (i in from..until) {
				tmp.append(text[i])
			}
			text = text.replaceFirst(tmp.toString().toRegex(), "")
			val textSB = StringBuilder(text)
			textSB.insert(instead, tmp)
			text = textSB.toString()
			return text
		}
	}
}