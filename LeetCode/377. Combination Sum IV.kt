class Solution {
    fun combinationSum4(nums: IntArray, target: Int): Int {
        val dp = IntArray(target+1) {0}
        dp[0] = 1

        for (sum in 1..target) {
            nums.forEach {
                if (sum - it >= 0) {
                    dp[sum] += dp[sum - it]
                }
            }
        }
        return dp[target]!!
    }
}