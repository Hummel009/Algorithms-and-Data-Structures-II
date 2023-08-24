package hummel

import java.nio.charset.StandardCharsets
import java.util.*

val arr: IntArray = IntArray(6)

fun main() {
	val scanner = Scanner(System.`in`, StandardCharsets.UTF_8.name())
	print("ENTER NUMBERS (example: 45 10 7 12 90 50):")
	for (i in 0..5) {
		arr[i] = scanner.nextIntSafe()
	}
	print("ENTER REMOVAL (example: 7):")
	val removal = scanner.nextIntSafe()
	scanner.close()
	val bst = ADS03(arr, removal)
	print("START TREE:")
	bst.print()
	println("\nTREE WITH RAB LINKS")
	bst.printRAB()
	bst.printRABLinked()
	println("\nTREE WITH ARB LINKS")
	bst.printARB()
	bst.printARBLinked()
	println("\nTREE WITH ABR LINKS")
	bst.printABR()
	bst.printABRLinked()
	print("\nREMOVING ELEMENT\nSTART TREE:")
	bst.remove()
	bst.print()
	println("\nTREE WITH RAB LINKS")
	bst.printRAB()
	bst.printRABLinked()
	println("\nTREE WITH ARB LINKS")
	bst.printARB()
	bst.printARBLinked()
	println("\nTREE WITH ABR LINKS")
	bst.printABR()
	bst.printABRLinked()
}

class ADS03(private var arr: IntArray, private var removal: Int) {
	private var root: Node? = null
	private var typeRAB = IntArray(100)
	private var typeARB = IntArray(100)
	private var typeABR = IntArray(100)
	private var counterRAB = 0
	private var counterARB = 0
	private var counterABR = 0

	init {
		for (i in arr.indices) {
			push(arr[i])
		}
	}

	fun print() {
		println()
		println()
		print(root ?: return, "", "")
	}

	private fun print(root: Node, s: String, isLeft: String) {
		var tab = s
		println(tab + isLeft + root.value)
		tab += "   "
		root.left?.let { print(it, tab, "L) ") }
		root.right?.let { print(it, tab, "R) ") }
	}

	fun printABR() {
		printABR(root ?: return)
		typeABR[counterABR] = (root ?: return).value
		counterABR++
	}

	private fun printABR(root: Node) {
		root.left?.let { printABR(it) }
		root.right?.let { printABR(it) }
		typeABR[counterABR] = root.value
		counterABR++
		print(root.value.toString() + " ")
	}

	fun printABRLinked() {
		println()
		println()
		printABRLinked(root ?: return, "", "")
	}

	private fun printABRLinked(root: Node, s: String, isLeft: String) {
		var tab = s
		println(tab + isLeft + root.value)
		tab += "   "
		root.left?.let { printABRLinked(it, tab, "L) ") }
		root.right?.let { printABRLinked(it, tab, "R) ") } ?: run {
			val i = typeABR.indexOf(root.value)
			println(tab + "R) --> " + typeABR[i + 1])
		}
	}

	fun printARB() {
		printARB(root ?: return)
		typeARB[counterARB] = (root ?: return).value
		counterARB++
	}

	private fun printARB(root: Node) {
		root.left?.let { printARB(it) }
		print(root.value.toString() + " ")
		typeARB[counterARB] = root.value
		counterARB++
		root.right?.let { printARB(it) }
	}

	fun printARBLinked() {
		println()
		println()
		printARBLinked(root ?: return, "", "")
	}

	private fun printARBLinked(root: Node, s: String, isLeft: String) {
		var tab = s
		println(tab + isLeft + root.value)
		tab += "   "
		root.left?.let { printARBLinked(it, tab, "L) ") }
		root.right?.let { printARBLinked(it, tab, "R) ") } ?: run {
			val i = typeARB.indexOf(root.value)
			println(tab + "R) --> " + typeARB[i + 1])
		}
	}

	fun printRAB() {
		printRAB(root ?: return)
		typeRAB[counterRAB] = (root ?: return).value
		counterRAB++
	}

	private fun printRAB(root: Node) {
		print(root.value.toString() + " ")
		typeRAB[counterRAB] = root.value
		counterRAB++
		root.left?.let { printRAB(it) }
		root.right?.let { printRAB(it) }
	}

	fun printRABLinked() {
		println()
		println()
		printRABLinked(root ?: return, "", "")
	}

	private fun printRABLinked(root: Node, s: String, isLeft: String) {
		var tab = s
		println(tab + isLeft + root.value)
		tab += "   "
		root.left?.let { printRABLinked(it, tab, "L) ") }
		root.right?.let { printRABLinked(it, tab, "R) ") } ?: run {
			val i = typeRAB.indexOf(root.value)
			println(tab + "R) --> " + typeRAB[i + 1])
		}
	}

	private fun push(value: Int) {
		root = push(root, value)
	}

	private fun push(root: Node?, key: Int): Node {
		if (root == null) {
			return Node(key)
		}
		if (key < root.value) {
			root.left = push(root.left, key)
		} else if (key > root.value) {
			root.right = push(root.right, key)
		}
		return root
	}

	fun remove() {
		root = null
		typeARB = IntArray(100)
		typeABR = IntArray(100)
		typeRAB = IntArray(100)
		val list = arr.toMutableList()
		list.remove(removal)
		arr = list.toIntArray()
		for (i in arr.indices) {
			push(arr[i])
		}
	}

	class Node(var value: Int) {
		var left: Node? = null
		var right: Node? = null
	}
}

fun Scanner.nextIntSafe(): Int {
	loop@ while (true) {
		try {
			return nextLine().toInt()
		} catch (e: Exception) {
			print("Error! Enter the correct value:")
			continue@loop
		}
	}
}