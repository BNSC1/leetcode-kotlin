class Solution {
    fun minimumMoves(grid: Array<IntArray>): Int {
        // Base Case
        var empties = 0
        repeat(3) { r ->
            repeat(3) { c ->
                if (grid[r][c] == 0) empties++
            }
        }
        if (empties == 0) return 0
        
        var res = Int.MAX_VALUE
        repeat(3) { emptyR -> repeat(3) { emptyC ->
            if (grid[emptyR][emptyC] == 0) {
                repeat(3) { spareR -> repeat(3) { spareC ->
                    val distance = abs(spareR - emptyR) + abs(spareC - emptyC)
                    if (grid[spareR][spareC] > 1) {
                        grid[spareR][spareC]--
                        grid[emptyR][emptyC]++
                        res = min(res, distance + minimumMoves(grid)) //backtrack
                        grid[spareR][spareC]++
                        grid[emptyR][emptyC]--
                    }
                } }
            }
        } }
        return res
    }
}