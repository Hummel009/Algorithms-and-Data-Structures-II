package hummel

import java.util.*

fun main() {
	val functions = HashMap<String, () -> Unit>()
	functions["0201"] = Ex0201::launch
	functions["0202"] = Ex0202::launch
	functions["0203"] = Ex0203::launch
	functions["0204"] = Ex0204::launch
	functions["0205"] = Ex0205::launch
	functions["0301"] = Ex0301::launch
	functions["0302"] = Ex0302::launch
	functions["0401"] = Ex0401::launch
	functions["0402"] = Ex0402::launch
	functions["0501"] = Ex0501::launch
	functions["0502"] = Ex0502::launch
	functions["0503"] = Ex0503::launch
	functions["0601"] = Ex0601::launch
	functions["0602"] = Ex0602::launch
	functions["0603"] = Ex0603::launch
	functions["0604"] = Ex0604::launch
	functions["0605"] = Ex0605::launch

	val scan = Scanner(System.`in`)
	val command = scan.nextLine()
	functions[command]?.invoke()
}