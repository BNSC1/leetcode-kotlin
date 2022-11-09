class Solution {
    var rows = 0
    var cols = 0

    fun numIslands(g: Array<CharArray>): Int {
        rows = g.size
        cols = g[0].size
        var res = 0

        for (r in 0 until rows) {
            for (c in 0 until cols) { //loop through 2D arrays
                if (g[r][c] == '1') { //if the coordinate is a land
                    dfs(g, r, c) //start turning the island to sea
                    res++ //add result count by 1
                }
            }
        }
        return res
    }

    fun dfs(g: Array<CharArray>, r: Int, c: Int) {
        if (r < 0 || c < 0 || r >= rows || c >= cols || g[r][c] == '0') return //if the coordinate is out of bounds or is a sea, do nothing

        g[r][c] = '0' //mark current coordinate as sea

        dfs(g, r-1, c)
        dfs(g, r, c-1)
        dfs(g, r+1, c)
        dfs(g, r, c+1) //recursion for 4 directions
    }
}
