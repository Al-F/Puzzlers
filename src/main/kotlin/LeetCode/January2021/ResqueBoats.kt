package LeetCode.January2021

/**
 * The i-th person has weight people[i], and each boat can carry a maximum weight of limit.d
 * Each boat carries at most 2 people at the same time, provided the sum of the weight of those people is at most limit.
 * Return the minimum number of boats to carry every given person.
 * (It is guaranteed each person can be carried by a boat.)
 */
class ResqueBoats {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        people.sortDescending()
        var boatCount = 0
        var start = 0
        var end = people.size-1
        while (start <= end){
            if(people[start]+people[end] <= limit){
                end--
            }
            start++
            boatCount++
        }
        return boatCount
    }
}