class Solution {
    fun minPathSum(grid: Array<IntArray>): Int {
        val rows = grid.size
        val cols = grid[0].size

        //use array elements as "cache" for dp
        for (r in 1 until rows) { //sum its left element up with itself
            grid[r][0] += grid[r-1][0]
        }
        for (c in 1 until cols) { //sum its top element up with itself
            grid[0][c] += grid[0][c-1]
        }

        for (r in 1 until rows) {
            for (c in 1 until cols) {
                val top = grid[r-1][c]
                val left = grid[r][c-1]
                grid[r][c] += Math.min(top, left) //take the path with the smallest sum
            }
        }
        return grid[rows-1][cols-1]
    }
}