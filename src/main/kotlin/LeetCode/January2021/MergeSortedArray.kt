package LeetCode.January2021

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
 */
class MergeSortedArray {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
//        var indexM = m - 1
//        var indexN = n - 1
//        var current = nums1.size - 1
//        while (indexM >= 0 && indexN >= 0) {
//            if (nums1[indexM] > nums2[indexN]) {
//                nums1[current] = nums1[indexM]
//                indexM--
//            } else {
//                nums1[current] = nums2[indexN]
//                indexN--
//            }
//            current--
//        }
//        while (indexM >= 0) {
//            nums1[current] = nums1[indexM]
//            indexM--
//            current--
//        }
//        while (indexN >= 0) {
//            nums1[current] = nums2[indexN]
//            indexN--
//            current--
//        }

        var indexM = m - 1
        var indexN = n - 1
        var current = nums1.size - 1
        while (indexM >= 0 || indexN >= 0) {
            if (indexN < 0){
                return
            }
            if (indexM >= 0 && nums1[indexM] > nums2[indexN]) {
                nums1[current] = nums1[indexM]
                indexM--
            } else {
                nums1[current] = nums2[indexN]
                indexN--
            }
            current--
        }
    }
}