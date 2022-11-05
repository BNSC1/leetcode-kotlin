class Solution {
    fun coinChange(coins: IntArray, sum: Int): Int {
        //to store calculated results, worst case we need sum + dp[0] of space
        //initial value is sum + 1 for edge case sum 0
        val dp = Array<Int>(sum+1) {sum + 1}
        dp[0] = 0 //sum 0 requires 0 coins

        for (sub in 1..sum) { //start from bottommost subproblems
            coins.forEach { c -> //loop using each coin for this problem
                if (sub - c >= 0) {
                    dp[sub] = Math.min(dp[sub], dp[sub - c] + 1) //dp[sub - c]: coin count without current coin + 1 current coin
                }
            }
        }
        //check if dp[sum] has value changed, if not it is impossible to count for this sum condition, returning -1
        return if (dp[sum] != sum + 1) dp[sum] else -1
    }
} //SC: O(sum * coins.size), TC: O(sum)
