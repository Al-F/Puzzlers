package leetCode.topInterviewQuestions.strings

class ReverseInteger {
    fun reverse(x: Int): Int {
        var rev = 0
        var init = x
        while (init != 0) {
            val pop = init % 10
            init /= 10
            if (rev > Int.MAX_VALUE / 10 || rev == Int.MAX_VALUE / 10 && pop > 7) return 0
            if (rev < Int.MIN_VALUE / 10 || rev == Int.MIN_VALUE / 10 && pop < -8) return 0
            rev = rev * 10 + pop
        }
        return rev
    }
}