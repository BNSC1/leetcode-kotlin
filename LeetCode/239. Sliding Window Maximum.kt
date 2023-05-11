class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val res = mutableListOf<Int>()
        val q = LinkedList<Int>()
        var l = 0
        for (r in 0 until nums.size) {
            while (q.isNotEmpty() && nums[q.peekLast()] < nums[r]) { //cleanse indexes with value smaller than the current one
                q.pollLast()
            }
            q.add(r)

            if (l > q.peekFirst()) { //remove out of bound index
                q.pollFirst()
            }

            if (r >= k - 1) { //gathered enough elements
                res.add(nums[q.peekFirst()])
                l++
            }
        }
        return res.toIntArray()
    }
}