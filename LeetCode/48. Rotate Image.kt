class Solution {
    fun rotate(m: Array<IntArray>): Unit {
        var start = 0
        var end = m.size - 1

        while (start < end) { //when there still is matrix to process
            repeat(end - start) { i -> //repeat until matrix bound
                //save top
                val topLeft = m[start][start + i]
                //move left to top
                m[start][start + i] = m[end - i][start]
                //move bottom to left
                m[end - i][start] = m[end][end - i]
                //move right to bottom
                m[end][end - i] = m[start + i][end]
                //move saved top to right
                m[start + i][end] = topLeft
            }
            start++
            end-- //go to interior
        }
    }
}