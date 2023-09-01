package hummel

import java.nio.charset.StandardCharsets
import java.util.*

var list: MutableList<Item> = ArrayList()
val scanner: Scanner = Scanner(System.`in`, StandardCharsets.UTF_8.name())

fun main() {
	printOptions()
	val functions = mapOf(
		"add" to ::addItem,
		"edit" to ::editItem,
		"remove" to ::removeItem,
		"show" to ::showAllItems,
		"sort name" to ::sortByName,
		"sort ids" to ::sortByIds,
	)
	while (true) {
		print("Enter the command: ")
		val command = scanner.nextLine()

		if ("exit" == command) {
			break
		}

		functions[command]?.invoke() ?: println("Command not found!")
	}
	scanner.close()
}

private fun addItem() {
	val base1SubIds = mutableListOf(73, 86)
	val base1Ids = mutableListOf(17, 81)
	val base2Sub1Ids = mutableListOf(11, 20, 33, 98)
	val base2Sub2Ids = mutableListOf(21, 27, 23, 79)
	val base2Ids = mutableListOf(16, 72, 32, 39)
	val base3SubSubIds = mutableListOf(45, 15, 68)
	val base3SubIds = mutableListOf(14, 56, 69)
	val base3Ids = mutableListOf(14, 51, 36)

	val base1Sub = mutableListOf(Item("b", base1SubIds))
	val base2Sub = mutableListOf(Item("y", base2Sub1Ids), Item("b", base2Sub2Ids))
	val base3SubSub = mutableListOf(Item("o", base3SubSubIds))
	val base3Sub = mutableListOf(Item("j", base3SubIds, base3SubSub))

	list.add(Item("a", base1Ids, base1Sub))
	list.add(Item("x", base2Ids, base2Sub))
	list.add(Item("z", base3Ids, base3Sub))

	println("Items were added.")
	showAllItems()
}

private fun editItem(item: Item) {
	item.ids.clear()
	item.subs.clear()
	println("Enter the new ids of the old item:")

	while (true) {
		val id = scanner.nextIntSafe()
		if (id == 0) {
			break
		}
		item.ids.add(id)
	}
	item.ids.sort()
	while (true) {
		print("Has sub-item? [Yes/No]: ")
		val read = scanner.nextLine()
		if (read == "No") {
			break
		}
		val ids = ArrayList<Int>()
		print("Enter the name: ")
		val name = scanner.nextLine()
		println("Enter the new ids:")
		while (true) {
			val id = scanner.nextIntSafe()
			if (id == 0) {
				break
			}
			ids.add(id)
		}
		ids.sort()
		val sub = Item(name, ids)
		item.subs.add(sub)
	}
}

private fun editItem() {
	val arr = list.toTypedArray()
	for (i in arr.indices) {
		println("$i. ${arr[i]}")
	}
	print("Enter the number of the old item: ")
	val id = scanner.nextIntSafe()
	if (id in arr.indices) {
		val item = arr[id]
		editItem(item)
	} else {
		print("Wrong! Enter the sub-item name then: ")
		val subName = scanner.nextLine()
		for (item in list) {
			for (sub in item.subs) {
				if (sub.name == subName) {
					editItem(item)
				}
			}
		}
	}
	showAllItems()
}

fun printOptions() {
	println("Available functions: add, edit, show, remove, exit, sort name, sort ids")
}

private fun removeItem() {
	val arr = list.toTypedArray()
	for (i in arr.indices) {
		println("$i. ${arr[i]}")
	}
	print("Enter the number of the removal item: ")
	val id = scanner.nextIntSafe()
	if (id in arr.indices) {
		val item = arr[id]
		list.remove(item)
	} else {
		print("Wrong! Enter the sub-item name then: ")
		val subName = scanner.nextLine()
		for (item in list) {
			for (sub in item.subs) {
				if (sub.name == subName) {
					item.subs.remove(sub)
				}
			}
		}
	}
	showAllItems()
}

private fun showAllItems() {
	for (cont in list) {
		println(cont)
	}
}

private fun sortByIds() {
	val comparator = Comparator.comparing { item: Item -> item.ids[0] }
	for (item in list) {
		item.subs.sortWith(comparator)
	}
	list.sortWith(comparator)
	showAllItems()
}

private fun sortByName() {
	val comparator = Comparator.comparing { item: Item -> item.name }
	list.sortWith(comparator)
	for (item in list) {
		item.subs.sortWith(comparator)
	}
	showAllItems()
}

class Item(
	var name: String, var ids: MutableList<Int>, var subs: MutableList<Item> = emptyList<Item>().toMutableList()
) {
	override fun toString(): String {
		if (subs.isEmpty()) {
			return "$name: $ids, sub does not exist."
		}
		return buildString {
			append("$name: $ids, subs:\n")
			append(subs.joinToString("\n") { it.toString() })
		}
	}
}

fun Scanner.nextIntSafe(): Int {
	return try {
		nextLine().toInt()
	} catch (e: Exception) {
		print("Error! Enter the correct value: ")
		nextIntSafe()
	}
}