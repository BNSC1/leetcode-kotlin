class Solution {
    fun solveNQueens(n: Int): List<List<String>> {
        val posDiags = HashSet<Int>()
        val negDiags = HashSet<Int>()
        val cols = HashSet<Int>()
        val res = mutableListOf<List<String>>()
        val board = mutableListOf<String>().apply {
            repeat(n) {
                add(".".repeat(n))
            }
        }

        fun backtrack(r: Int = 0) {
            if (r == n) {
                res.add(board.toList())
                return
            }
            repeat(n) { c ->
                if (c in cols ||
                    (r + c) in posDiags ||
                    (r - c) in negDiags) return@repeat
                posDiags.add(r + c)
                negDiags.add(r - c)
                cols.add(c)
                board[r] = board[r].replaceRange(c..c, "Q")

                backtrack(r + 1)

                posDiags.remove(r + c)
                negDiags.remove(r - c)
                cols.remove(c)
                board[r] = board[r].replaceRange(c..c, ".")
            }
        }

        backtrack()
        return res
    }
}