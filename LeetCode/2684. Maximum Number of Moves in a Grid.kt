class Solution {
    fun maxMoves(g: Array<IntArray>): Int {
        val rows = g.size
        val cols = g[0].size
        val dp = Array(rows) {IntArray(cols) {0}}

        fun findMax(r: Int, c: Int) {
            Dirs.values().forEach { dir ->
                val nextR = r + dir.r
                val nextC = c + dir.c
                if (nextR in 0 until rows &&
                    nextC < cols &&
                    g[r][c] < g[nextR][nextC]) {
                    dp[r][c] = Math.max(dp[r][c], dp[nextR][nextC]+1)
                }
            }
        }

        for (c in cols - 1 downTo 0) {
            for (r in 0 until rows) {
                findMax(r, c)
            }
        }
        var res = 0
        for (r in 0 until rows) {
            res = Math.max(dp[r][0], res)
        }
        return res
    }
}
enum class Dirs(val r: Int, val c: Int) {UPPER_RIGHT(-1, 1), RIGHT(0, 1), LOWER_RIGHT(1, 1)}