package hummel

import java.util.*

var list: MutableList<Content> = ArrayList()

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
            "sort content" -> sortByContent()
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

    val base1Sub = mutableListOf(Content("b", base1SubIds))
    val base2Sub = mutableListOf(Content("y", base2Sub1Ids), Content("b", base2Sub2Ids))
    val base3SubSub = mutableListOf(Content("o", base3SubSubIds))
    val base3Sub =  mutableListOf(Content("j", base3SubIds, base3SubSub))

    list.add(Content("a", base1Ids, base1Sub))
    list.add(Content("x", base2Ids, base2Sub))
    list.add(Content("z", base3Ids, base3Sub))

    println("Objects were added.")
    showAllItems()
}

private fun editObject(content: Content) {
    content.contentIds.clear()
    content.contentSubs.clear()
    println("Enter the new ids of the old object.")
    val scan = Scanner(System.`in`)

    while (true) {
        val read = scan.nextLine().toInt()
        if (read == 0) {
            break
        }
        content.contentIds.add(read)
    }
    content.contentIds.sort()
    while (true) {
        println("Has sub-content? (Yes/No)")
        val read = scan.nextLine()
        if (read == "No") {
            break
        }
        val temp = ArrayList<Int>()
        println("Enter the name:")
        val name = scan.nextLine()
        println("Enter the new ids:")
        while (true) {
            val reads = scan.nextLine().toInt()
            if (reads == 0) {
                break
            }
            temp.add(reads)
        }
        temp.sort()
        val sub = Content(name, temp)
        content.contentSubs.add(sub)
    }
}

private fun editItem() {
    val arr = list.toTypedArray()
    for (i in arr.indices) {
        println("$i. ${arr[i]}")
    }
    println("Enter the number of the old object.")
    val scan = Scanner(System.`in`)
    val id = scan.nextLine().toInt()
    if (id in arr.indices) {
        val content = arr[id]
        editObject(content)
    } else {
        println("Wrong! Enter the sub-object name then.")
        val subContentName = scan.nextLine()
        for (content in list) {
            for (sub in content.contentSubs) {
                if (sub.contentName == subContentName) {
                    editObject(content)
                }
            }
        }
    }
    showAllItems()
}

fun printOptions() {
    println("Available functions:")
    println("add, edit, show, remove, exit, sort name, sort content")
}

private fun removeItem() {
    val arr = list.toTypedArray()
    for (i in arr.indices) {
        println("$i. ${arr[i]}")
    }
    println("Enter the number of the removal object.")
    val scan = Scanner(System.`in`)
    val id = scan.nextLine().toInt()
    if (id in arr.indices) {
        val content = arr[id]
        list.remove(content)
    } else {
        println("Wrong! Enter the sub-object name then.")
        val subContentName = scan.nextLine()
        for (content in list) {
            for (sub in content.contentSubs) {
                if (sub.contentName == subContentName) {
                    content.contentSubs.remove(sub)
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

private fun sortByContent() {
    val comparator = Comparator.comparing { o1: Content -> o1.contentIds[0] }
    for (c in list) {
        c.contentSubs.sortWith(comparator)
    }
    list.sortWith(comparator)
    showAllItems()
}

private fun sortByName() {
    val comparator = Comparator.comparing { o1: Content -> o1.contentName }
    list.sortWith(comparator)
    for (c in list) {
        c.contentSubs.sortWith(comparator)
    }
    showAllItems()
}

class Content {
    var contentSubs: MutableList<Content>
    var contentIds: MutableList<Int>
    var contentName: String

    constructor(fName: String, fIds: MutableList<Int>) {
        contentName = fName
        contentIds = fIds
        contentSubs = emptyList<Content>().toMutableList()
    }

    constructor(fName: String, fIds: MutableList<Int>, fSub: MutableList<Content>) {
        contentName = fName
        contentIds = fIds
        contentSubs = fSub
    }

    override fun toString(): String {
        if (contentSubs.isEmpty()) {
            return "$contentName: $contentIds, sub does not exist."
        }
        val s = StringBuilder().append(contentName).append(": ").append(contentIds.toString()).append(", subs:\n")
        for (c in contentSubs) {
            s.append(c.toString()).append("\n")
        }
        return s.toString()
    }
}