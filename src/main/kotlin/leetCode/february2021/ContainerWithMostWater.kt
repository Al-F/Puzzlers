package leetCode.february2021

import java.lang.Integer.max
import kotlin.math.min

/**
 * Given n non-negative integers a1, a2, ..., an ,
 * where each represents a point at coordinate (i, ai). n vertical lines are drawn such
 * that the two endpoints of the line i is at (i, ai) and (i, 0).
 * Find two lines, which, together with the x-axis forms a container,
 * such that the container contains the most water.
 *
 * Notice that you may not slant the container.
 */
class ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        var start = 0
        var end = height.size - 1
        var max = 0
        while (start < end) {
            val square = min(height[start], height[end]) * (end - start)
            max = max(square, max)

            if (height[start] < height[end]) {
                start++
            } else end--
        }
        return max
    }
}