class Solution {
    fun spiralOrder(m: Array<IntArray>): List<Int> {
        val res = mutableListOf<Int>()
        var left = 0
        var right = m[0].size
        var top = 0
        var bottom = m.size

        while (left < right && top < bottom) { //loop until there is no row/column to process
            for (i in left until right) {
                res.add(m[top][i])
            } //add top row of elements from left to right to result
            top++ //then move top row down by 1

            for (i in top until bottom) {
                res.add(m[i][right-1])
            } //add right column of elements from top to bottom to result
            right-- //then move right column to left by 1

            if (!(left < right && top < bottom)) break //check if there is still row/column to process

            for (i in right-1 downTo left) {
                res.add(m[bottom-1][i])
            } //add bottom row of elements from right to left to result
            bottom-- //then move bottom row up by 1

            for (i in bottom-1 downTo top) {
                res.add(m[i][left])
            } //add left column from bottom to up to result
            left++ //then move left column to right by 1
        }
        return res
    }
}
