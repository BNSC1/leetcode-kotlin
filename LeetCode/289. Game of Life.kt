class Solution {
    fun gameOfLife(b: Array<IntArray>): Unit {
        // 0 -> was dead, will also be dead
        // 1 -> was alive, will be dead
        // 2 -> was dead, will be alive
        // 3 -> was alive, will also be alive
        val rows = b.size
        val cols = b[0].size

        fun countNei(r: Int, c: Int): Int {
            var nei = 0
            for (nr in r-1..r+1) {
                for (nc in c-1..c+1) {
                    if (nr !in 0 until rows ||
                        nc !in 0 until cols ||
                        (nr == r && nc == c)) continue
                    if (b[nr][nc] in intArrayOf(1,3)) nei++
                }
            }
            return nei
        }

        repeat(rows) { r ->
            repeat(cols) { c ->
                val nei = countNei(r, c)
                if (b[r][c] == 1) {
                    if (nei in 2..3) b[r][c] = 3
                } else if (nei == 3) b[r][c] = 2
            }
        }

        repeat(rows) { r ->
            repeat(cols) { c ->
                if (b[r][c] == 1) b[r][c] = 0
                else if (b[r][c] in 2..3) b[r][c] = 1
            }
        }
    }
}