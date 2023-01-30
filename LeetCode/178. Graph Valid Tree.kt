fun validTree(n: Int, edges: Array<IntArray>): Boolean {
    if (n == 0) return true
    val visited = HashSet<Int>()
    val neighbors = HashMap<Int, MutableList<Int>>() //node : neighbors
    repeat(n) {
        neighbors[it] = mutableListOf()
    }
    edges.forEach {
        neighbors[it[0]]!!.add(it[1])
        neighbors[it[1]]!!.add(it[0])
    } //add to each other's neighbor list

    fun dfs(i: Int, prev: Int): Boolean {
        if (i in visited) {
            return false
        } //loop detected, meaning it is not a valid tree

        visited.add(i) //add to visited
        for (j in neighbors[i]!!) {
            if (j == prev) continue //skip if the neighbor is the same as the previous node
            if (!dfs(j,i)) return false //if loop detected, return false
        }
        return true
    }
    return dfs(0, -1) && n == visited.size //dfs should return true and visited set should have size of n
}
