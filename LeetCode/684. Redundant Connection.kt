class Solution {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val parent = IntArray(edges.size + 1) {it}
        fun union(x: Int, y: Int) {
            parent[x] = y
        }
        fun find(x: Int): Int {
            if (x == parent[x]) return x
            parent[x] = find(parent[x])
            return parent[x]
        }

        for (edge in edges) {
            val v1 = edge[0]
            val v2 = edge[1]
            val p1 = find(v1)
            val p2 = find(v2)
            if (p1 == p2) return intArrayOf(v1, v2)
            union(p1, p2)
        }
        return intArrayOf()
    }
}