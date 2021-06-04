package leetCode.june2021

fun main() {
    val f = InterleavingString()
    f.isInterleave(
        "aabcc",
        "dbbca",
        "aadbbcbcac"
    )
}

class InterleavingString {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        if ((s3.isEmpty() && s2.isEmpty() && s1.isEmpty())
            || (s1.isEmpty() && s2.contentEquals(s3))
            || (s2.isEmpty() && s1.contentEquals(s3))
        ) return true
        if (s3.length != s1.length + s2.length) return false
        val s3Arr = Array(26) { 0 }
        val s12Arr = Array(26) { 0 }
        s3.forEach { s3Arr[it-'a']++ }
        s1.forEach { s12Arr[it-'a']++ }
        s2.forEach { s12Arr[it-'a']++ }
        for (i in 0..25){
            if (s3Arr[i] != s12Arr[i]) return false
        }
        if (!containsInCorrectOrder(s1, s3)) return false
        if (!containsInCorrectOrder(s2, s3)) return false

        return true
    }

    private fun containsInCorrectOrder(s1: String, s3: String): Boolean {
        var start = 0
        for (i in s1){
            var found = false
            for (j in start until s3.length){
                if (i == s3[j]){
                    start = j+1
                    found=true
                    break
                }
            }
            if (!found) return false
        }
        return true
    }
}