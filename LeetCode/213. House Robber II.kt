class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        fun rob(from: Int, to: Int): Int {
            var currRob = 0
            var maxRob = 0
            for (i in from until to) {
                val max = maxOf(currRob + nums[i], maxRob)
                currRob = maxRob
                maxRob = max
            }
            return maxRob
        }
        return maxOf(rob(0, nums.size - 1),
                     rob(1, nums.size))
    }
}