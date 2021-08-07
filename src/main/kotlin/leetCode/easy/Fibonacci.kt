package leetCode.easy

fun main() {
    val f = Fibonacci()
    //print(f.fibonacci().take(11).toList())
    f.fibonacci().forEach {
        println(it)
    }
    print(f.fibonacciAsFold(10))
}

class Fibonacci {
    fun fibonacci() = sequence {
        var pair = 0 to 1
        var i = 1

        while (i < 10) {
            yield(pair.first)
            pair = pair.second to pair.first + pair.second
            i++
        }
    }

    fun fibonacciAsFold(n: Int) = (2..n).fold(1 to 1) { (f, s), _ -> s to f + s }.second
}