package hummel

import java.nio.charset.StandardCharsets
import java.util.*

val scanner: Scanner = Scanner(System.`in`, StandardCharsets.UTF_8.name())

fun main() {
	val functions = mapOf(
		"0201" to Ex0201::launch,
		"0202" to Ex0202::launch,
		"0203" to Ex0203::launch,
		"0204" to Ex0204::launch,
		"0205" to Ex0205::launch,
		"0301" to Ex0301::launch,
		"0302" to Ex0302::launch,
		"0401" to Ex0401::launch,
		"0402" to Ex0402::launch,
		"0501" to Ex0501::launch,
		"0502" to Ex0502::launch,
		"0503" to Ex0503::launch,
		"0601" to Ex0601::launch,
		"0602" to Ex0602::launch,
		"0603" to Ex0603::launch,
		"0604" to Ex0604::launch,
		"0605" to Ex0605::launch
	)
	while (true) {
		print("Enter the number of the lab: ")
		val command = scanner.nextLine()

		if ("exit" == command) {
			break
		}

		functions[command]?.invoke() ?: println("Command not found!")
	}
	scanner.close()
}