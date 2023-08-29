class Solution {
    fun maxAreaOfIsland(g: Array<IntArray>): Int {
        val rows = g.size
        val cols = g[0].size
        val dirs = intArrayOf(-1,0,1,0,-1)

        var res = 0
        val visit = HashSet<Pair<Int,Int>>()
        val q = LinkedList<Pair<Int,Int>>()
        fun count(): Int {
            var res = 0
            while (q.isNotEmpty()) {
                res++
                val coord = q.poll()
                for (d in 0 until 4) {
                    val nr = coord.first + dirs[d]
                    val nc = coord.second + dirs[d+1]
                    val newCoord = nr to nc
                    if (nr in 0 until rows &&
                        nc in 0 until cols &&
                        newCoord !in visit &&
                        g[nr][nc] == 1) {
                            q.add(newCoord)
                            visit.add(newCoord)
                        }
                }
            }
            return res
        }

        repeat(rows) { r ->
            repeat(cols) { c ->
                val coord = r to c
                if (coord !in visit &&
                    g[r][c] == 1) {
                        q.add(coord)
                        visit.add(coord)
                        res = maxOf(res, count())
                    }
            }
        }
        return res
    }
}