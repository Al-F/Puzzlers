package leetCode.may2021

fun main() {
    val f = ValidNumber()
    f.isNumber("e9")
}
class ValidNumber {
    fun isNumber(s: String): Boolean {
        val integer = Regex("[+-]?[0-9]+")
        val decimal = Regex("[+-]?\\.[0-9]+")
        val decimal2 = Regex("[+-]?[0-9]+\\.[0-9]+")
        val decimal3 = Regex("[+-]?[0-9]+\\.")
        val numberI = Regex("[+-]?[0-9]+e[+-]?[0-9]+")
        val numberII = Regex("[+-]?[0-9]+E[+-]?[0-9]+")
        val number = Regex("[+-]?[0-9]+\\.[0-9]+e[+-]?[0-9]+")
        val number4 = Regex("[+-]?[0-9]+\\.[0-9]+E[+-]?[0-9]+")
        val number2 = Regex("[+-]?\\.[0-9]+e[+-]?[0-9]+")
        val number5 = Regex("[+-]?\\.[0-9]+E[+-]?[0-9]+")
        val number3 = Regex("[+-]?[0-9]+\\.e[+-]?[0-9]+")
        val number6 = Regex("[+-]?[0-9]+\\.E[+-]?[0-9]+")
        return integer.matches(s)
                || decimal.matches(s)
                || decimal2.matches(s)
                || decimal3.matches(s)
                || number.matches(s)
                || numberI.matches(s)
                || numberII.matches(s)
                || number4.matches(s)
                || number2.matches(s)
                || number3.matches(s)
                || number5.matches(s)
                || number6.matches(s)
    }
}