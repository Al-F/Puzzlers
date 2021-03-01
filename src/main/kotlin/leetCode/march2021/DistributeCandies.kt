package leetCode.march2021


class DistributeCandies {
    fun distributeCandies(candyType: IntArray): Int {
        return Math.min((candyType.size / 2), candyType.distinct().size)
    }
}