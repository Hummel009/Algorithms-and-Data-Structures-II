package hummel

import hummel.Room.RoomType
import hummel.Room.WindowType
import java.util.*

fun main() {
	println("─────────────────────────────────────────────────────────────────────────")
	println("─██████──────────██████─██████████████─██████████████████─██████████████─")
	println("─██░░██████████████░░██─██░░░░░░░░░░██─██░░░░░░░░░░░░░░██─██░░░░░░░░░░██─")
	println("─██░░░░░░░░░░░░░░░░░░██─██░░██████░░██─████████████░░░░██─██░░██████████─")
	println("─██░░██████░░██████░░██─██░░██──██░░██─────────████░░████─██░░██─────────")
	println("─██░░██──██░░██──██░░██─██░░██████░░██───────████░░████───██░░██████████─")
	println("─██░░██──██░░██──██░░██─██░░░░░░░░░░██─────████░░████─────██░░░░░░░░░░██─")
	println("─██░░██──██████──██░░██─██░░██████░░██───████░░████───────██░░██████████─")
	println("─██░░██──────────██░░██─██░░██──██░░██─████░░████─────────██░░██─────────")
	println("─██░░██──────────██░░██─██░░██──██░░██─██░░░░████████████─██░░██████████─")
	println("─██░░██──────────██░░██─██░░██──██░░██─██░░░░░░░░░░░░░░██─██░░░░░░░░░░██─")
	println("─██████──────────██████─██████──██████─██████████████████─██████████████─")
	println("─────────────────────────────────────────────────────────────────────────")

	var floor: Floors
	var roomType: RoomType
	var windowType: WindowType

	print("Enter the color of the floor (green, black, grey): ")
	loop@ while (true) {
		try {
			val input = readln().uppercase()
			floor = Floors.valueOf(input)
			break
		} catch (e: Exception) {
			print("Error! Enter the correct value: ")
			continue@loop
		}
	}

	print("Enter the color of the room (green, black, grey): ")
	val color = readln()

	print("Enter if there is glowing in the room (true/false): ")
	val hasGlowing = readln()

	print("Enter if glowing is direct in the room (true/false): ")
	val isGlowingDirect = readln()

	print("Enter if there is med environment in the room (true/false): ")
	val hasMedEnvironment = readln()

	print("Enter the room type of the room: ")
	loop@ while (true) {
		try {
			val input = readln().uppercase()
			roomType = RoomType.valueOf(input)
			break
		} catch (e: Exception) {
			print("Error! Enter the correct value: ")
			continue@loop
		}
	}

	print("Enter the window type of the room: ")
	loop@ while (true) {
		try {
			val input = readln().uppercase()
			windowType = WindowType.valueOf(input)
			break
		} catch (e: Exception) {
			print("Error! Enter the correct value: ")
			continue@loop
		}
	}

	val room = Room(color, hasGlowing, isGlowingDirect, hasMedEnvironment, roomType, windowType)

	val blackRoom = Room("grey", "true", "false", "false", RoomType.ROOM, WindowType.SMALL)
	val lab = Room("grey", "true", "true", "true", RoomType.ROOM, WindowType.BIG)
	val prison = Room("green", "false", "false", "false", RoomType.ROOM, WindowType.NONE)

	println("|=======================================|")
	println("|==============  GO BACK  ==============|")
	println("|=======================================|")
	println()
	when (floor) {
		Floors.BLACK -> if (room == blackRoom) {
			println(
				"""
				You are on the first floor.
				Turn left and go 12 steps.
				Turn to the angle of 45 degrees to right and go 50 steps.
				Turn to the angle of 45 degrees to right and go 18 steps.
				Turn to the angle of 90 degrees to right and go forward.
				Turn to the angle of 45 degrees to right and go 48 steps.
				Then use lift.Turn to the angle of 45 degrees to left and go 50 metres.
				""".trimIndent()
			)
		} else {
			val rand = Random()
			val left1 = rand.nextInt(20) + 20
			val left2 = rand.nextInt(20) + 20
			val right = rand.nextInt(20) + 20
			println(
				"""You are on the second floor.
				Turn left and go $left1 steps.
				Then turn right and go $right steps.
				Turn left and go $left2 steps.
				Then use lift.
				""".trimIndent()
			)
			drawAsAMatrix(left1, right, left2)
		}

		Floors.GREY -> if (room == lab) {
			println(
				"""
				You are on the second floor.
				Turn to the angle of 45 degrees to right and go forward.
				Turn to the angle of 90 degrees to right and go forward.
				Turn to the angle of 45 degrees to right and go forward.
				Then use lift.
				You are on the first floor.
				Turn left and go 12 steps.
				Turn to the angle of 45 degrees to right and go 50 steps.
				Turn to the angle of 45 degrees to right and go 18 steps.
				Turn to the angle of 90 degrees to right and go forward.
				Turn to the angle of 45 degrees to right and go 48 steps.
				Then use lift.Turn to the angle of 45 degrees to left and go 50 metres.
				""".trimIndent()
			)
		} else {
			val rand = Random()
			val left1 = rand.nextInt(20) + 20
			val left2 = rand.nextInt(20) + 20
			val right = rand.nextInt(20) + 20
			println(
				"""You are on the second floor.
				Turn left and go $left1 steps.
				Then turn right and go $right steps.
				Turn left and go $left2 steps.
				Then use lift.
				""".trimIndent()
			)
			drawAsAMatrix(left1, right, left2)
		}

		Floors.GREEN -> if (room == prison) {
			println(
				"""
				You are on the third floor.
				Turn left and go 8 steps.
				Then use lift.
				You are on the second floor.
				Turn to the angle of 45 degrees to right and go forward.
				Turn to the angle of 90 degrees to right and go forward.
				Turn to the angle of 45 degrees to right and go forward.
				Then use lift.
				You are on the first floor.
				Turn left and go 12 steps.
				Turn to the angle of 45 degrees to right and go 50 steps.
				Turn to the angle of 45 degrees to right and go 18 steps.
				Turn to the angle of 90 degrees to right and go forward.
				Turn to the angle of 45 degrees to right and go 48 steps.
				Then use lift.
				Turn to the angle of 45 degrees to left and go 50 metres.
				""".trimIndent()
			)
		} else {
			val rand = Random()
			val left1 = rand.nextInt(20) + 20
			val left2 = rand.nextInt(20) + 20
			val right = rand.nextInt(20) + 20
			println(
				"""You are on the second floor.
				Turn left and go $left1 steps.
				Then turn right and go $right steps.
				Turn left and go $left2 steps.
				Then use lift.
				""".trimIndent()
			)
			drawAsAMatrix(left1, right, left2)
		}
	}
}

fun drawAsAMatrix(left1: Int, right: Int, left2: Int) {
	var lLeft1 = left1 / 5
	var lRight = right / 5
	var lLeft2 = left2 / 5
	val matrix = Array(26) { Array(26) { " " } }
	var x = 12
	var y = 12
	while (lLeft1 > 0) {
		matrix[x][y] = "G"
		x--
		lLeft1--
	}
	while (lRight > 0) {
		matrix[x][y] = "G"
		y--
		lRight--
	}
	while (lLeft2 > 0) {
		matrix[x][y] = "G"
		x++
		lLeft2--
	}
	matrix[x][y] = "L"
	matrix[12][12] = "S"
	println("|=======================================|")
	println("|===============  ROUTE  ===============|")
	println("|=======================================|")
	println()
	println("==========================")
	for (i in matrix.indices) {
		for (j in matrix[i].indices) {
			print(matrix[i][j])
		}
		println()
	}
	println("==========================")
}

enum class Floors {
	BLACK, GREY, GREEN;
}

data class Room(
	var color: String,
	var hasGlowing: String,
	var isGlowingDirect: String,
	var hasMedEnvironment: String,
	var roomType: RoomType,
	var windowType: WindowType
) {
	enum class RoomType {
		BLOCK, ROOM, CORRIDOR;
	}

	enum class WindowType {
		BIG, SMALL, NONE;
	}
}