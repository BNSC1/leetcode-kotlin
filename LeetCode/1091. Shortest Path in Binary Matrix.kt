class Solution {
    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        if (grid[0][0] == 1) return -1
        val rows = grid.size
        val cols = grid[0].size

        val q = LinkedList<Pair<Int, Int>>().apply { add(0 to 0) }
        val visited = HashSet<Pair<Int, Int>>().apply { add(0 to 0) }
        var step = 0

        while (q.isNotEmpty()) {
            step++
            repeat(q.size) {
                val coord = q.poll()
                if (coord.first == rows - 1 &&
                    coord.second == cols - 1) return step
                
                Dirs.values().forEach { d ->
                    val r = coord.first + d.r
                    val c = coord.second + d.c
                    if (r in 0 until rows &&
                        c in 0 until cols &&
                        grid[r][c] == 0 &&
                        (r to c) !in visited) {
                            val nextCoord = r to c
                            q.add(nextCoord)
                            visited.add(nextCoord)
                    }
                }
            }
        }
        return -1
    }
}
enum class Dirs(val r: Int = 0, val c: Int = 0) {
    UP(r = -1),
    DOWN(r = 1),
    LEFT(c = -1),
    RIGHT(c = 1),
    UPLEFT(-1, -1),
    DOWNLEFT(1, -1),
    UPRIGHT(-1, 1),
    DOWNRIGHT(1, 1)
}