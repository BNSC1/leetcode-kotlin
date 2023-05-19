class Tester {
    @Test
    fun main() {
        Solution().apply {
            minMeetingRooms(arrayOf(intArrayOf(0, 30), intArrayOf(5, 10),intArrayOf(15, 20))) `should be equal to` 2
            minMeetingRooms(arrayOf(intArrayOf(7, 10), intArrayOf(2, 4))) `should be equal to` 1
            minMeetingRooms(arrayOf(intArrayOf(9, 10), intArrayOf(2, 9))) `should be equal to` 1
            minMeetingRooms(arrayOf(intArrayOf(1,4), intArrayOf(1,4), intArrayOf(2,4), intArrayOf(3,5))) `should be equal to` 4
        }
    }
}
class Solution {
    fun minMeetingRooms(intervals: Array<IntArray>): Int {
        var res = 0
        val starts = IntArray(intervals.size)
        val ends = IntArray(intervals.size)
        intervals.forEachIndexed { i , n ->
            starts[i] = n[0]
            ends[i] = n[1]
        }
        starts.sort()
        ends.sort()
        val rooms = LinkedList<Int>() //end time

        for (i in intervals.indices) {
            val start = starts[i]
            val end = ends[i]
            while (rooms.isNotEmpty() && rooms.peek() <= start) {
                rooms.poll()
            }
            rooms.add(end)
            res = rooms.size.coerceAtLeast(res)
        }

        return res
    }
}