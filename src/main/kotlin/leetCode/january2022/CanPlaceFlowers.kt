package leetCode.january2022

class CanPlaceFlowers {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var left = n
        var ind = 0
        val taken = HashSet<Int>()
        while (ind < flowerbed.size && left > 0){
            if (flowerbed[ind] == 0){
                val leftPlace = if (ind>0){
                    flowerbed[ind-1] == 0 && !taken.contains(ind-1)
                } else true
                val right = if (ind<flowerbed.size-1){
                    flowerbed[ind+1] == 0 && !taken.contains(ind+1)
                } else true
                if (leftPlace && right) {
                    taken.add(ind)
                    left--
                }
            }
            ind++
        }
        return left == 0
    }
}