class Solution {
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        if (n == 1) return listOf(0)
        var n = n //num of nodes
        var leaves = mutableListOf<Int>()
        val adj = Array<MutableSet<Int>>(n) { HashSet() } //array with size of n, contains node references

        edges.forEach { edge ->
            adj[edge[0]].add(edge[1])
            adj[edge[1]].add(edge[0]) //refer nodes to each other
        }
        for (i in 0 until n) {
            if (adj[i].size == 1) leaves.add(i) //add nodes with only 1 edge
        }
        while (n > 2) {
            n -= leaves.size //update num of nodes
            val tmp = mutableListOf<Int>()
            leaves.forEach { i ->
                val j = adj[i].iterator().next()
                adj[j].remove(i) //remove outer leaves
                if (adj[j].size == 1) tmp.add(j) //add those with only 1 node reference to the next leaves
            }
            leaves = tmp
        }
        return leaves //in the end, there will be 1 node, or 2 nodes having reference to each other
    }
}
