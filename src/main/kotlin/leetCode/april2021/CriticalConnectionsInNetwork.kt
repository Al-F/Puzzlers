package leetCode.april2021

import java.util.*
import kotlin.collections.HashMap

typealias Nodes = MutableList<Node>

class Node(val n: Int) {
    var index = -1
    var lowLink = -1
    var onStack = false

    override fun toString() = n.toString()
}

class CriticalConnectionsInNetwork {

    fun criticalConnections(n: Int, connections: List<List<Int>>): List<List<Int>> {
        val map = HashMap<Node, Nodes>()
        val nodes: MutableList<Node> = mutableListOf()
        connections.forEach {
            val value = map.getOrDefault(Node(it[0]), mutableListOf())
            value.add(Node(it[1]))
        }
        for (i in 0 until n) {
            nodes.add(Node(i))
        }
        tarjan(DirectedGraph(nodes, map))
        return connections
    }

    class DirectedGraph(val vs: Nodes, val es: Map<Node, Nodes>)

    fun tarjan(g: DirectedGraph): List<Nodes> {
        val sccs = mutableListOf<Nodes>()
        var index = 0
        val s = Stack<Node>()

        fun strongConnect(v: Node) {
            // Set the depth index for v to the smallest unused index
            v.index = index
            v.lowLink = index
            index++
            s.push(v)
            v.onStack = true

            // consider successors of v
            for (w in g.es[v]!!) {
                if (w.index < 0) {
                    // Successor w has not yet been visited; recurse on it
                    strongConnect(w)
                    v.lowLink = minOf(v.lowLink, w.lowLink)
                } else if (w.onStack) {
                    // Successor w is in stack s and hence in the current SCC
                    v.lowLink = minOf(v.lowLink, w.index)
                }
            }

            // If v is a root node, pop the stack and generate an SCC
            if (v.lowLink == v.index) {
                val scc = mutableListOf<Node>()
                do {
                    val w = s.pop()
                    w.onStack = false
                    scc.add(w)
                } while (w != v)
                sccs.add(scc)
            }
        }

        for (v in g.vs) if (v.index < 0) strongConnect(v)
        return sccs
    }
}