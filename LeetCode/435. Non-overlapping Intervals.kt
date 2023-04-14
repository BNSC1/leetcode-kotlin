class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        intervals.sortBy { it[0] }
        var res = 0

        var prevEnd = intervals[0][1]
        for (i in 1 until intervals.size) {
            val (start, end) = intervals[i]
            if (start >= prevEnd) { //not overlapping
                prevEnd = end
            } else { //overlapping
                prevEnd = Math.min(prevEnd, end) //ignore(remove) the interval with greater end
                res++
            }
        }
        return res
    }
}