class Solution {
    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        val dp = HashMap<Pair<Int, Int>,Int>() //coord : longest
        
        fun dfs(r: Int, c: Int, prev: Int = -1): Int { //prev defaults to -1 so first calc passes the first guard clause
            if (r < 0 || c < 0 ||
                r >= matrix.size || c >= matrix[0].size ||
                matrix[r][c] <= prev) { //out of bounds or less than/equal to prev value
                    return 0
                }
            val coord = Pair(r, c)
            if (coord in dp) { //already calculated
                return dp[coord]!!
            }
            var res = 1
            res = (dfs(r + 1, c, matrix[r][c]) + 1).coerceAtLeast(res)
            res = (dfs(r - 1, c, matrix[r][c]) + 1).coerceAtLeast(res)
            res = (dfs(r, c + 1, matrix[r][c]) + 1).coerceAtLeast(res)
            res = (dfs(r, c - 1, matrix[r][c]) + 1).coerceAtLeast(res)
            dp[coord] = res
            return res
        }
        for (r in 0 until matrix.size) {
            for (c in 0 until matrix[0].size) {
                dfs(r, c)
            }
        }
        return dp.values.max()!!
    }
}