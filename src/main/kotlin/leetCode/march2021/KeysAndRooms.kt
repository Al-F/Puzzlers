package leetCode.march2021

import java.util.*

/**
 * There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1,
 * and each room may have some keys to access the next room.
 * Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1]
 * where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.
 * Initially, all the rooms start locked (except for room 0).
 * You can walk back and forth between rooms freely.
 * Return true if and only if you can enter every room.
 */
fun main() {
    val f = KeysAndRooms()
    f.canVisitAllRooms(arrayListOf(arrayListOf(1), arrayListOf(2), arrayListOf(3), arrayListOf()))
}
class KeysAndRooms {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val openedRooms = BooleanArray(rooms.size) { false }
        if (rooms.isEmpty()) return true
        if (rooms[0].isEmpty()) return rooms.size == 1

        val stack = Stack<Int>()
        openedRooms[0] = true
        rooms[0].forEach {
            stack.push(it)
            openedRooms[it] = true
        }
        while (stack.isNotEmpty()) {
            val room = stack.pop()
            val keys = rooms[room]
            keys.forEach {
                if (!openedRooms[it]){
                    openedRooms[it] = true
                    stack.push(it)
                }
            }
        }
        return openedRooms.all { it }
    }
}