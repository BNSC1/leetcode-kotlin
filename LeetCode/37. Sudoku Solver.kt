class Solution {
    fun solveSudoku(b: Array<CharArray>): Unit {
        fun isValid(r: Int, c: Int, d: Char): Boolean {
            repeat(9) { currR -> //check if the digit exists in the column
                if (b[currR][c] == d) return false
            }
            repeat(9) { currC -> //check if the digit exists in the row
                if (b[r][currC] == d) return false
            }

            val gridOffsetR = r/3*3
            val gridOffsetC = c/3*3
            
            repeat(3) { gridR ->
                repeat(3) { gridC -> //check if the digit exists in the grid
                    if (b[gridOffsetR+gridR][gridOffsetC+gridC] == d) return false
                }
            }
            return true
        }

        fun dfs(r: Int = 0, c: Int = 0): Boolean {
            if (r == 9) return true //reached end of the board
            if (c == 9) return dfs(r+1, 0) //reached end of the row
            if (b[r][c] != '.') return dfs(r, c+1) //filled cell

            for (d in '1'..'9') {
                if (!isValid(r, c, d)) continue
                b[r][c] = d
                if (dfs(r, c+1) == true) return true
                b[r][c] = '.'
            }
            return false
        }

        dfs()
    }
}