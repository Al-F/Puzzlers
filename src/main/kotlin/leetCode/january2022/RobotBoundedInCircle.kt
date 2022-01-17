package leetCode.january2022

class RobotBoundedInCircle {
    fun isRobotBounded(instructions: String): Boolean {
        var left = 0
        var right = 0
        var coordinates = 0 to 0
        val directions = Array(4) { 0 to 0 }
        directions[0] = 0 to 1
        directions[1] = -1 to 0
        directions[2] = 0 to -1
        directions[3] = 1 to 0

        var ind = 0
        instructions.forEach { letter ->
            when (letter) {
                'L' -> {
                    left++
                    ind = (ind + 3) % 4
                }
                'R' -> {
                    right++
                    ind = (ind + 1) % 4
                }
                'G' -> {
                    coordinates =
                        coordinates.first + directions[ind].first to coordinates.second + directions[ind].second
                }
            }
        }

        return (coordinates.first == 0 && coordinates.second == 0) || (left - right) % 4 != 0
    }

    fun isRobotBoundedRefactor(instructions: String): Boolean {
        var x = 0
        var y = 0
        val directions = Array(4) { 0 to 0 }
        directions[0] = 0 to 1
        directions[1] = -1 to 0
        directions[2] = 0 to -1
        directions[3] = 1 to 0

        var ind = 0
        instructions.forEach { letter ->
            when (letter) {
                'L' -> ind = (ind + 3) % 4
                'R' -> ind = (ind + 1) % 4
                'G' -> {
                    x += directions[ind].first
                    y += directions[ind].second
                }
            }
        }

        return (x == 0 && y == 0) || ind > 0
    }
}

