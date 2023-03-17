class Solution {
    fun searchMatrix(m: Array<IntArray>, target: Int): Boolean {
        var top = 0
        var bottom = m.size - 1
        var row = 0
        
        //find the most possible row
        while (top <= bottom) {
            row = (top + bottom) / 2
            if (target > m[row].last()) top = row + 1
            else if (target < m[row][0]) bottom = row - 1
            else break //when the possible row is found
        }
        if (top > bottom) return false //no possible row is found

        //find the target element in the row
        var l = 0
        var r = m[0].size - 1
        while (l <= r) {
            val mid = (l + r) / 2
            if (target > m[row][mid]) l = mid + 1 //shrink the left boundary to right if the mid element is smaller
            else if (target < m[row][mid]) r = mid - 1 //shrink the right boundary to right if the mid element is greater
            else return true //target is found
        }
        return false //return false if not found
    }
}