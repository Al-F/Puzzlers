package leetCode.easy

class DetermineColorOfChessboardSquare {
    fun squareIsWhite(coordinates: String): Boolean {
        //In ascii 'a' has index 97
        return (coordinates[1].toInt() % 2 == 0 && coordinates[0].toInt() % 2 == 1)
                || (coordinates[1].toInt() % 2 == 1 && coordinates[0].toInt() % 2 == 0)
    }
}