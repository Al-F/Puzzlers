package leetCode.march2021

import java.lang.Math.PI
import kotlin.random.Random

class GenerateRandomPointInCircle(radius: Double, x_center: Double, y_center: Double) {
    private val centerX = x_center
    private val centerY = y_center
    private val radius = radius

    fun randPointNope(): DoubleArray {
        val random = Math.sqrt(radius * Random.nextDouble())
        val theta = Random.nextDouble(0.0, 1.0)
        val x = centerX + random * Math.cos(theta)
        val y = centerY + random * Math.cos(theta)
        return doubleArrayOf(x, y)
    }

    fun randPoint(): DoubleArray {
        val len: Double = Math.sqrt(Math.random()) * radius
        val deg = Math.random() * 2 * PI
        val x: Double = centerX + len * Math.cos(deg)
        val y: Double = centerY + len * Math.sin(deg)
        return doubleArrayOf(x, y)
    }

}