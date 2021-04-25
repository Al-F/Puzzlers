package leetCode.april2021

fun main() {
    val f = BrickWall()
    f.leastBricks(
        arrayListOf(
            arrayListOf(1, 2, 2, 1),
            arrayListOf(3, 1, 2),
            arrayListOf(1, 3, 2),
            arrayListOf(2, 4),
            arrayListOf(3, 1, 2),
            arrayListOf(1, 3, 1, 1)
        )
    )
}

class BrickWall {
    fun leastBricks(wall: List<List<Int>>): Int {
        val hashMap = HashMap<Int, Int>()
        var end = 0
        wall.forEach { row ->
            var cum = 0
            row.forEach { brickLenth ->
                cum += brickLenth
                val value = hashMap.getOrPut(cum, { 0 })
                hashMap[cum] = value + 1
            }
            end = cum
        }

        var max = 0
        hashMap.forEach {  (key, value) ->
            if (key!=end){
                max = Math.max(max, value)
            }
        }
        return wall.size - max
    }
}