class Solution {
    var rows = 0
    var cols = 0

    fun orangesRotting(g: Array<IntArray>): Int {
        val q = LinkedList<IntArray>() //queue for the rotten
        var time = 0 //elapsed time
        var cnt = 0 //fresh orange count
        rows = g.size
        cols = g[0].size

        val dirs = arrayOf(intArrayOf(1,0),
                           intArrayOf(-1,0),
                           intArrayOf(0,1),
                           intArrayOf(0,-1)
                           ) //all 4 directions

        for (r in 0 until rows) {
            for (c in 0 until cols) { //loop through all cells
                if (g[r][c] == 1) cnt++ //add to fresh count if it is a fresh orange
                if (g[r][c] == 2) q.add(intArrayOf(r, c)) //add to rotten queue if it is a rotten one
            }
        }

        while (q.isNotEmpty() && cnt > 0) { //while the rotten queue is not empty and fresh oranges still persist
            for (i in 0 until q.size) { //loop current queued rotten oranges
                val rotten = q.poll()
                for(dir in dirs) { //search 4 directions
                    val row = rotten[0] + dir[0]
                    val col = rotten[1] + dir[1]

                    if (row < 0 || row >= rows ||
                        col < 0 || col >= cols ||
                        g[row][col] != 1) { continue } //if the cell is out of bounds or is not fresh, skip

                    g[row][col] = 2
                    q.add(intArrayOf(row, col))
                    cnt-- //make the fresh orange rot, then add to the queue
                }
            }
            time++ //add time for 1 iteration
        }
        return if (cnt == 0) time else -1 //if there still is/are fresh orange(s), return -1, otherwise return elapsed time
    }
}
