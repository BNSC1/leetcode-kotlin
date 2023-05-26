class Solution {
    fun smallestRange(nums: List<List<Int>>): IntArray {
        val minHeap = PriorityQueue<Coord>(compareBy { nums[it.r][it.c] })
        var max = Int.MIN_VALUE
        var start = 0
        var end = Int.MAX_VALUE
        repeat(nums.size) { r ->
            minHeap.offer(Coord(r, 0))
            max = (nums[r][0]).coerceAtLeast(max)
        }
        while (nums.size == minHeap.size) {
            val min = minHeap.poll()
            val r = min.r
            val c = min.c
            if (end - start > max - nums[r][c]) {
                start = nums[r][c]
                end = max
            }
            if (c + 1 < nums[r].size) { //move index of current row
                minHeap.offer(Coord(r, c + 1))
                max = (nums[r][c + 1]).coerceAtLeast(max)
            }
        }
        return intArrayOf(start, end)
    }
}
class Coord(val r: Int, val c: Int)