package leetCode.january2022

class ComplementOfBase10Integer {
    fun bitwiseComplement(n: Int): Int {
        return Integer.parseInt(n.toString(2).map { if (it == '0') '1' else '0' }.joinToString(""), 2)
    }
}