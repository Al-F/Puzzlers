package leetCode.easy

fun main() {
    val f = ImplementStrStr()
    f.strStr(
        "abaaabba",
        "bba"
    )
}

class ImplementStrStr {
    fun strStr(haystack: String, needle: String): Int {
        if (needle.isBlank()) return 0
        if (needle.length > haystack.length) return -1
        for (i in 0 until haystack.length - needle.length + 1) {
            if (haystack[i] == needle[0]) {
                var same = true
                for (j in 1 until needle.length) {
                    if (needle[j] != haystack[j + i]) {
                        same = false
                        break
                    }
                }
                if (same) return i
            }
        }
        return -1

    }
}