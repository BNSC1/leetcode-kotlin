class Solution {
    fun solve(b: Array<CharArray>): Unit {
        val rows = b.size
        val cols = b[0].size
        val dirs = intArrayOf(-1,0,1,0,-1)

        val visit = HashSet<Pair<Int,Int>>() //mark NOT to be flipped
        fun dfs(r: Int, c: Int) {
            val coord = r to c
            if (r !in 0 until rows ||
                c !in 0 until cols ||
                coord in visit ||
                b[r][c] != 'O') return
            visit.add(coord)
            for (d in 0 until 4) {
                val nr = r + dirs[d]
                val nc = c + dirs[d+1]
                dfs(nr, nc)
            }
        }
        repeat(rows) { r ->
            val coordLeft = r to 0
            val coordRight = r to cols-1
            for (coord in listOf(coordLeft, coordRight)) {
                if (coord !in visit &&
                    b[coord.first][coord.second] == 'O') {
                        dfs(coord.first, coord.second)
                    }
            }
        }
        repeat(cols) { c ->
            val coordTop = 0 to c
            val coordBottom = rows-1 to c
            for (coord in listOf(coordTop, coordBottom)) {
                if (coord !in visit &&
                    b[coord.first][coord.second] == 'O') {
                        dfs(coord.first, coord.second)
                    }
            }
        }
        repeat(rows) { r ->
            repeat(cols) { c ->
                val coord = r to c
                if (coord !in visit && b[r][c] == 'O') b[r][c] = 'X'
            }
        }
    }
}