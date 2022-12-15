class Solution {
    fun exist(b: Array<CharArray>, w: String): Boolean {
        val rows = b.size
        val cols = b[0].size
        val path = HashSet<Pair<Int, Int>>() //save coordinates of found char

        fun dfs(r: Int, c: Int, i: Int): Boolean {
            if (i >= w.length) return true //return true if iteration is already greater than the char count, means we already found all chars
            val grid = Pair(r, c) //current grid coordinate
            if(r < 0 || c < 0 ||
               r >= rows || c >= cols || //if the grid is out of bounds
               b[r][c] != w[i] || //or the grid does not have the char we are looking for
               grid in path) return false //or the grid has already been marked for previous chars, return false

            //if the grid has exactly what we need
            path.add(grid) //save the coordinate of it
            val res = dfs(r + 1, c, i + 1) ||
                      dfs(r - 1, c, i + 1) ||
                      dfs(r, c + 1, i + 1) ||
                      dfs(r, c - 1, i + 1) //recursion in 4 directions and if 1 of them returns true, we found the word
            path.remove(grid) //after the recursions, revert path state for checking the next grid path
            return res //then return the result
        }

        for (r in 0 until rows) {
            for (c in 0 until cols) { //loop through every single grid
                if (dfs(r, c, 0)) return true //return true as soon as we found a path for all chars
            }
        }
        return false
    }
}
