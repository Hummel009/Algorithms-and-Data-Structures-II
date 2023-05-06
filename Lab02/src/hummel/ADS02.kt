package hummel

import java.util.*

var list: MutableList<Item> = ArrayList()

fun main() {
	val scan = Scanner(System.`in`)
	printOptions()
	sus@ while (true) {
		when (scan.nextLine()) {
			"add" -> addItem()
			"edit" -> editItem()
			"remove" -> removeItem()
			"show" -> showAllItems()
			"sort name" -> sortByName()
			"sort ids" -> sortByIds()
			"exit" -> break@sus
		}
	}
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
	println("Enter the new ids of the old item.")
	val scan = Scanner(System.`in`)

	while (true) {
		val id = scan.nextIntSafe()
		if (id == 0) {
			break
		}
		item.ids.add(id)
	}
	item.ids.sort()
	while (true) {
		println("Has sub-item? (Yes/No)")
		val read = scan.nextLine()
		if (read == "No") {
			break
		}
		val ids = ArrayList<Int>()
		println("Enter the name:")
		val name = scan.nextLine()
		println("Enter the new ids:")
		while (true) {
			val id = scan.nextIntSafe()
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
	println("Enter the number of the old item.")
	val scan = Scanner(System.`in`)
	val id = scan.nextIntSafe()
	if (id in arr.indices) {
		val item = arr[id]
		editItem(item)
	} else {
		println("Wrong! Enter the sub-item name then.")
		val subName = scan.nextLine()
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
	println("Available functions:")
	println("add, edit, show, remove, exit, sort name, sort item")
}

private fun removeItem() {
	val arr = list.toTypedArray()
	for (i in arr.indices) {
		println("$i. ${arr[i]}")
	}
	println("Enter the number of the removal item.")
	val scan = Scanner(System.`in`)
	val id = scan.nextIntSafe()
	if (id in arr.indices) {
		val item = arr[id]
		list.remove(item)
	} else {
		println("Wrong! Enter the sub-item name then.")
		val subName = scan.nextLine()
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
	val comparator = Comparator.comparing { o1: Item -> o1.ids[0] }
	for (item in list) {
		item.subs.sortWith(comparator)
	}
	list.sortWith(comparator)
	showAllItems()
}

private fun sortByName() {
	val comparator = Comparator.comparing { o1: Item -> o1.name }
	list.sortWith(comparator)
	for (item in list) {
		item.subs.sortWith(comparator)
	}
	showAllItems()
}

class Item(
	var name: String,
	var ids: MutableList<Int>,
	var subs: MutableList<Item> = emptyList<Item>().toMutableList()
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
	loop@ while (true) {
		try {
			return nextLine().toInt()
		} catch (e: Exception) {
			print("Error! Enter the correct value: ")
			continue@loop
		}
	}
}