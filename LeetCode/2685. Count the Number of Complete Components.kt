class Solution {
    fun countCompleteComponents(n: Int, edges: Array<IntArray>): Int {
        val uf = UnionFind(n)
        val groups = HashSet<Vertex>()
        val edgeCounts = IntArray(n)
        edges.forEach { e ->
            uf.unionSet(e[0], e[1])
            edgeCounts[e[0]]++
            edgeCounts[e[1]]++
        }
        repeat(n) { i ->
            groups.add(uf.findParent(i))
        }
        repeat(n) { i -> //if a vertex of a group does not have edge count+1 of size of group, remove the group
            if (uf.getGroupSize(i) != edgeCounts[i] + 1) groups.remove(uf.findParent(i))
        }
        return groups.size
    }
}
class Vertex(val index: Int, var verticesCount: Int = 1) {
    var parent = this
}
class UnionFind(n: Int) {
    private val vertices = Array(n) { i -> Vertex(i) }

    fun findParent(x: Int): Vertex {
        val vertex = vertices[x]
        if (vertex.parent != vertex) vertex.parent = findParent(vertex.parent.index)
        return vertex.parent
    }

    fun unionSet(x: Int, y: Int) {
        val parentX = findParent(x)
        val parentY = findParent(y)
        if (parentX == parentY) return

        if (parentX.verticesCount < parentY.verticesCount) parentX.parent = parentY
        else parentY.parent = parentX
        val countSum = parentX.verticesCount + parentY.verticesCount
        parentY.verticesCount = countSum
        parentX.verticesCount = countSum
    }

    fun getGroupSize(x: Int): Int {
        return findParent(x).verticesCount
    }
}