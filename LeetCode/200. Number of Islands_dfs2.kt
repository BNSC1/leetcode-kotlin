class Solution {
    lateinit var visited: Array<BooleanArray>
    var rows = 0
    var cols = 0

    fun numIslands(g: Array<CharArray>): Int {
        rows = g.size
        cols = g[0].size
        visited = Array(rows) { BooleanArray(cols) }
        var res = 0

        for (r in 0 until rows) {
            for (c in 0 until cols) { //loop through 2D arrays
                if (!visited[r][c] && g[r][c] == '1') { //if the coordinate is a land and has not been visited
                    dfs(g, r, c) //start turning the island to sea
                    res++ //add result count by 1
                }
            }
        }
        return res
    }

    fun dfs(g: Array<CharArray>, r: Int, c: Int) {
        if (r < 0 || c < 0 || r >= rows || c >= cols || visited[r][c] || g[r][c] == '0') return //if the coordinate is out of bounds or is a sea or has been visited, do nothing

        visited[r][c] = true //mark current coordinate as visited

        dfs(g, r-1, c)
        dfs(g, r, c-1)
        dfs(g, r+1, c)
        dfs(g, r, c+1) //recursion for 4 directions
    }
}
