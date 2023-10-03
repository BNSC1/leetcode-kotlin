class Solution {
    fun mySqrt(x: Int): Int {
        var l = 1
        var r = x
        while (l <= r) {
            val m = l + (r - l) / 2
            if (m == x / m) return m //(m == x / m) is effectively (m*m == x) except it prevents overflow
            if (m > x / m) r = m - 1
            else l = m + 1
        }
        return r
    } //TC: O(logx), SC: O(1)
}