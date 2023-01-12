class Solution {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val rows = heights.size
        val cols = heights[0].size
        val pacific = HashSet<Pair<Int, Int>>()
        val atlantic = HashSet<Pair<Int, Int>>() //set for coordinates that can be flowed to perspective oceans
        val res = mutableListOf<List<Int>>()

        fun dfs(r: Int, c: Int, visit: HashSet<Pair<Int,Int>>, prevHeight: Int) {
            val coord = Pair(r, c)

            if (coord in visit ||
                r < 0 || c < 0 ||
                r >= rows || c >= cols ||
                heights[r][c] < prevHeight
                ) { //if the coordinate has been visited, or it is out of bounds, or it is less than previous height
                    return
                }
            visit.add(coord) //add to the ocean
            dfs(r + 1, c, visit, heights[r][c])
            dfs(r - 1, c, visit, heights[r][c])
            dfs(r, c + 1, visit, heights[r][c])
            dfs(r, c - 1, visit, heights[r][c]) //check neighbor coordinates in 4 directions
        }

        for (c in 0 until cols) {
            dfs(0, c, pacific, heights[0][c]) //check coordinates that flows to the top of pacific
            dfs(rows - 1, c, atlantic, heights[rows - 1][c]) //check coordinates that flows to the bottom of atlantic
        }

        for (r in 0 until rows) {
            dfs(r, 0, pacific, heights[r][0]) //check coordinates that flows to the left of pacific
            dfs(r, cols - 1, atlantic, heights[r][cols - 1]) //check coordinates that flows to the right of atlantic
        }

        for (r in 0 until rows) {
            for (c in 0 until cols) {
                val coord = Pair(r, c)
                if (coord in pacific && coord in atlantic) { //add the coordinate to the result if it appears in both oceans
                    res.add(coord.toList())
                }
            }
        }
        return res
    }
}
