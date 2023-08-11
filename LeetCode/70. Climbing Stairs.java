class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 2];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            dp[i+1] += dp[i];
            dp[i+2] += dp[i];
        }
        return dp[n];
    }
} //TC: O(n), SC: O(n)