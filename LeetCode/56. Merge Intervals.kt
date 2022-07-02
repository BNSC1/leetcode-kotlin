class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it[0] } //sort the array so we put element with the smallest start value to the start
        val res = LinkedList<IntArray>()
        res.add(intervals[0])

        for (i in 1..intervals.size-1) {
            var last = res.lastIndex
            val lastEnd = res[last][1]
            val currentStart = intervals[i][0]
            val currentEnd = intervals[i][1]

            if (lastEnd >= currentStart) {
                res[last][1] = Math.max(lastEnd, currentEnd) //take bigger of their end if they are overlapping
            } else {
                res.add(intervals[i]) //add to the result
            }
        }
        return res.toTypedArray() //convert the list to an int array
    }
}
