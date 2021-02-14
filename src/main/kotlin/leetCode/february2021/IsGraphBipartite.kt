package leetCode.february2021

import java.util.*

/**
 * Given an undirected graph, return true if and only if it is bipartite.
 * Recall that a graph is bipartite if we can split its set of nodes into two independent subsets A and B,
 * such that every edge in the graph has one node in A and another node in B.
 * The graph is given in the following form: graph[i] is a list of indexes j
 * for which the edge between nodes i and j exists. Each node is an integer between 0 and graph.length - 1.
 * There are no self edges or parallel edges: graph[i] does not contain i,
 * and it doesn't contain any element twice.
 */
fun main() {
    val f = IsGraphBipartite()
    //[[],[2,4,6],[1,4,8,9],[7,8],[1,2,8,9],[6,9],[1,5,7,8,9],[3,6,9],[2,3,4,6,9],[2,4,5,6,7,8]]
    print(f.isBipartite(
        arrayOf(intArrayOf(), intArrayOf(2,4,6), intArrayOf(1,4,8,9), intArrayOf(7,8),
        intArrayOf(1,2,8,9), intArrayOf(6,9), intArrayOf(1,5,7,8,9), intArrayOf(3,6,9),
            intArrayOf(2,3,4,6,9), intArrayOf(2,4,5,6,7,8))))

    print(f.isBipartite(
        arrayOf(intArrayOf(), intArrayOf(3), intArrayOf(), intArrayOf(1))))
}

class IsGraphBipartite {
    fun isBipartite(graph: Array<IntArray>): Boolean {
        val colorBook = IntArray(graph.size) { -1 }
        val needToVisit = LinkedList<Int>() // There will be stored indexes

        while (colorBook.contains(-1)){
            val index = colorBook.indexOfFirst { it == -1 }
            colorBook[index] = 1
            needToVisit.add(index)
            val part = iterateOnGraph(needToVisit, graph,colorBook)
            if (!part) return false
        }
        return true
    }

    private fun iterateOnGraph(needToVisit: LinkedList<Int>, graph: Array<IntArray>, colorBook: IntArray): Boolean{
        while (needToVisit.size != 0){
            val currentIndex = needToVisit.poll()
            val toBeVisited = graph[currentIndex]
            for (i in toBeVisited.indices){
                if (colorBook[toBeVisited[i]] == colorBook[currentIndex]){
                    return false
                }
                if (colorBook[toBeVisited[i]] == -1){
                    colorBook[toBeVisited[i]] = 1 - colorBook[currentIndex]
                    needToVisit.add(toBeVisited[i])
                }
            }
        }
        return true
    }
}