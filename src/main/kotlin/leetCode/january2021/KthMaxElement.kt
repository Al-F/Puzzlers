package leetCode.january2021

/**
 * Find the kth largest element in an unsorted array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
class KthMaxElement {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        /**
         * Straightforward
         * Runtime: 216 ms
         * Memory Usage: 37.4 MB
         */
//        nums.sortDescending()
//        return nums[k-1]

        /**
         * Bubble sort
         * Runtime: 292 ms
         * Memory Usage: 37 MB
         */
        for (i in 0 .. k){
            for (j in i until nums.size){
                if(nums[j] > nums[i]){
                    nums[i] = nums[j].also { nums[j] = nums[i] }
                }
            }
        }
        return nums[k-1]

        /**
         * Not mine just beautiful
         *
         */
//        val priorityQueue = PriorityQueue<Int>()
//        nums.forEach { num ->
//            priorityQueue.add(num)
//            if (priorityQueue.size > k) priorityQueue.poll()
//        }
//        return priorityQueue.peek()
    }
}