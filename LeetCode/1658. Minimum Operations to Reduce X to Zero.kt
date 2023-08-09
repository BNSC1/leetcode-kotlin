class Solution {
    fun minOperations(nums: IntArray, x: Int): Int {
        val target = nums.sum() - x
        var sum = 0
        var res = -1

        var start = 0
        repeat(nums.size) { end ->
            sum += nums[end]
            while (start <= end && sum > target) {
                sum -= nums[start++]
            }
            if (sum == target) res = maxOf(res, end - start + 1)
        }
        return if (res == -1) -1 else nums.size - res
    }
}