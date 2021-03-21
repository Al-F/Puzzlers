package leetCode.march2021

class UndergroundSystem() {
    val people = HashMap<Int, Pair<String, Int>>()
    val stations = HashMap<Pair<String, String>, Pair<Int, Int>>()
    fun checkIn(id: Int, stationName: String, t: Int) {
        people[id] = stationName to t
    }

    fun checkOut(id: Int, stationName: String, t: Int) {
        val value = people[id]
        val stationsHere = value?.first ?: ""
        people.remove(id)
        val stationsPair = Pair(stationsHere, stationName)
        val stationsCur = stations.getOrPut(stationsPair) { 0 to 0 }
        stations[stationsPair] = Pair(stationsCur.first + (t - value!!.second), stationsCur.second+1)
    }

    fun getAverageTime(startStation: String, endStation: String): Double {
        val stationsCur = stations.getOrPut(Pair(startStation, endStation)) { 0 to 0 }
        return stationsCur.first.toDouble() / stationsCur.second
    }

}