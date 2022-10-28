class Solution {
    fun updateMatrix(m: Array<IntArray>): Array<IntArray> {
        val q = LinkedList<IntArray>()

        for (r in 0 until m.size) {
            for (c in 0 until m[0].size) {
                if (m[r][c] == 0) { // check if it is sea, queue if it is
                    q.add(intArrayOf(r, c))
                } else m[r][c] = -1 // if not, mark it as visited by assigning -1
            }
        }

        while (q.isNotEmpty()) { // loop until the queue is empty
            val c = q.poll()
            val x = c[0]
            val y = c[1]

            for (d in arrayOf(
                arrayOf(1, 0),
                arrayOf(-1, 0),
                arrayOf(0, 1),
                arrayOf(0, -1))
                ) {
                val tmpX = x + d[0]
                val tmpY = y + d[1] // loop each direction

                if (tmpX >= 0 && tmpX < m.size &&
                    tmpY >= 0 && tmpY < m[0].size &&
                    m[tmpX][tmpY] == -1) { // if the coordinate is within bounds and is a land (-1)

                    m[tmpX][tmpY] = m[x][y] + 1 // assign the land to be current coordinate value + 1
                    q.add(intArrayOf(tmpX, tmpY)) // add the land to queue
                }
            }
        }
        return m
    }
}
