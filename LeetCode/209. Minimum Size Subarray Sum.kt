class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var res = Int.MAX_VALUE
        var start = 0
        var sum = 0
        
        repeat(nums.size) { end ->
            sum += nums[end]

            while (sum >= target) {
                res = minOf(res, end - start + 1)
                sum -= nums[start++]
            }
        }
        return if (res == Int.MAX_VALUE) 0 else res
    }
}