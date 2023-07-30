package hummel

import java.util.*

object Ex0502 {
	private var scan = Scanner(System.`in`)
	private var divider = 1000000007
	private var base = 263

	fun launch() {
		val hashTable = HashTable(scan.nextInt())
		val operationsCount = scan.nextInt()
		for (i in 0 until operationsCount) {
			val operation = scan.next()
			if (operation.startsWith("a")) {
				hashTable.add(scan.next())
			} else if (operation.startsWith("c")) {
				println(hashTable.getValues(scan.nextInt()))
			} else if (operation.startsWith("f")) {
				println(hashTable.find(scan.next()))
			} else {
				hashTable.delete(scan.next())
			}
		}
	}

	class HashTable(size: Int) {
		private var table: Array<Words?> = arrayOfNulls(size)

		fun add(string: String) {
			val hashCode = hashCode(string)
			if (table[hashCode] == null) {
				table[hashCode] = Words()
			}
			table[hashCode]!!.add(string)
		}

		fun delete(string: String) {
			val hashCode = hashCode(string)
			if (table[hashCode] != null && !table[hashCode]!!.isEmpty) {
				table[hashCode]!!.delete(string)
			}
		}

		fun find(string: String): String {
			val hashCode = hashCode(string)
			if (table[hashCode] == null || table[hashCode]!!.isEmpty) {
				return "no"
			}
			return if (table[hashCode]!!.contains(string)) {
				"yes"
			} else "no"
		}

		fun getValues(hashCode: Int): String {
			return if (table[hashCode] == null || table[hashCode]!!.isEmpty) {
				""
			} else table[hashCode]!!.values
		}

		private fun hashCode(string: String): Int {
			var hashCode: Long = 0
			for ((i, ch) in string.toCharArray().withIndex()) {
				hashCode = ((hashCode + ch.code.toLong() * pow(i)) % divider + divider) % divider
			}
			return (hashCode % table.size).toInt()
		}

		private fun pow(pow: Int): Long {
			var result: Long = 1
			for (i in 0 until pow) {
				result = result * base % divider
			}
			return result
		}

		class Words {
			private var wordsList: MutableList<String> = LinkedList()

			fun add(string: String) {
				if (!contains(string)) {
					(wordsList as LinkedList<String>).addFirst(string)
				}
			}

			operator fun contains(string: String): Boolean {
				var contains = false
				for (str in wordsList) {
					if (str == string) {
						contains = true
						break
					}
				}
				return contains
			}

			fun delete(string: String) {
				val iterator = wordsList.iterator()
				while (iterator.hasNext()) {
					if (iterator.next() == string) {
						iterator.remove()
						break
					}
				}
			}

			val values: String
				get() {
					val stringBuilder = StringBuilder()
					for (aWordsList in wordsList) {
						stringBuilder.append(aWordsList)
						stringBuilder.append(" ")
					}
					return stringBuilder.toString()
				}
			val isEmpty: Boolean
				get() = wordsList.isEmpty()
		}
	}
}
