package leetCode.easy

class ParkingSystem(var big: Int, var medium: Int, var small: Int) {
    fun addCar(carType: Int): Boolean {
        when (carType) {
            1 -> {
                big--
                return big >= 0
            }
            2 -> {
                medium--
                return medium >= 0
            }
            3 -> {
                small--
                return small >= 0
            }
        }
        return false
    }
}