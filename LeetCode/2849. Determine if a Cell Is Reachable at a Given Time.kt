class Solution {
    fun isReachableAtTime(sx: Int, sy: Int, fx: Int, fy: Int, t: Int): Boolean {
        if (sx == fx && sy == fy && t == 1) return false
        val dstX = Math.abs(fx - sx)
        val dstY = Math.abs(fy - sy)
        val diag = minOf(dstY, dstX) //diagonal movement
        val line = maxOf(dstY, dstX) - diag //straight line movement
        val shortest = diag + line
        return t >= shortest
    }
}