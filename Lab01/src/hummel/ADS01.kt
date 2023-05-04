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
    val input = Scanner(System.`in`)

    var floor: Floors?
    do {
        println("Enter the color of the floor: ")
        val color = input.nextLine()
        floor = Floors.forName(color)
    } while (floor == null)

    println("Enter the color of the room (green, black, grey): ")
    val color = input.nextLine()

    println("Enter if there is glowing in the room (true/false): ")
    val hasGlowing = input.nextLine()

    println("Enter if glowing is direct in the room (true/false): ")
    val isGlowingDirect = input.nextLine()

    println("Enter if there is med environment in the room (true/false): ")
    val hasMedEnvironment = input.nextLine()

    var type: RoomType?
    do {
        println("Enter the room type of the room: ")
        val r = input.nextLine()
        type = RoomType.forName(r)
    } while (type == null)

    var wtype: WindowType?
    do {
        println("Enter the window type of the room: ")
        val w = input.nextLine()
        wtype = WindowType.forName(w)
    } while (wtype == null)

    val room = Room(color, hasGlowing, isGlowingDirect, hasMedEnvironment, type, wtype)

    val blackRoom = Room("grey", "true", "false", "false", RoomType.ROOM, WindowType.SMALL)
    val lab = Room("grey", "true", "true", "true", RoomType.ROOM, WindowType.BIG)
    val prison = Room("green", "false", "false", "false", RoomType.ROOM, WindowType.NONE)

    println("|=======================================|")
    println("|==============  GO BACK  ==============|")
    println("|=======================================|")
    println()
    when (floor) {
        Floors.ONE -> if (compareRooms(room, blackRoom)) {
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
            println("You are on the second floor.\nTurn left and go $left1 steps.\nThen turn right and go $right steps.\nTurn left and go $left2 steps.\nThen use lift.\n")
            drawAsAMatrix(left1, right, left2)
        }

        Floors.TWO -> if (compareRooms(room, lab)) {
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
            println("You are on the second floor.\nTurn left and go $left1 steps.\nThen turn right and go $right steps.\nTurn left and go $left2 steps.\nThen use lift.\n")
            drawAsAMatrix(left1, right, left2)
        }

        Floors.THREE -> if (compareRooms(room, prison)) {
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
            println("You are on the second floor.\nTurn left and go $left1 steps.\nThen turn right and go $right steps.\nTurn left and go $left2 steps.\nThen use lift.\n")
            drawAsAMatrix(left1, right, left2)
        }
    }
}

fun compareRooms(room1: Room, room2: Room): Boolean {
    return room1.isGlowingDirect == room2.isGlowingDirect && room1.color == room2.color && room1.hasGlowing == room2.hasGlowing && room1.hasMedEnvironment == room2.hasMedEnvironment && room1.roomType.roomName == room2.roomType.roomName && room1.windowType.windowName == room2.windowType.windowName
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

enum class Floors(val eName: String) {
    ONE("black"), TWO("grey"), THREE("green");

    companion object {
        fun forName(search: String): Floors? {
            for (color in values()) {
                if (search == color.eName) {
                    return color
                }
            }
            return null
        }
    }
}

class Room(
    var color: String,
    var hasGlowing: String,
    var isGlowingDirect: String,
    var hasMedEnvironment: String,
    var roomType: RoomType,
    var windowType: WindowType
) {
    enum class RoomType(val roomName: String) {
        OTSEK("otsek"), ROOM("room"), CORRIDOR("corridor");

        companion object {
            fun forName(search: String): RoomType? {
                for (r in values()) {
                    if (search == r.roomName) {
                        return r
                    }
                }
                return null
            }
        }
    }

    enum class WindowType(val windowName: String) {
        BIG("big"), SMALL("small"), NONE("none");

        companion object {
            fun forName(search: String): WindowType? {
                for (r in values()) {
                    if (search == r.windowName) {
                        return r
                    }
                }
                return null
            }
        }
    }
}