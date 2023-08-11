class Solution {
    public int coinChange(int[] coins, int amount) {
        int MAX = amount + 1;
        int[] dp = new int[MAX];
        Arrays.fill(dp, MAX);
        dp[amount] = 0;

        for (int diff = amount; diff > 0; diff--) {
            for(int c : coins) {
                if (c <= diff) dp[diff - c] = Math.min(dp[diff - c], dp[diff] + 1);
            }
        }
        if (dp[0] == MAX) return -1;
        return dp[0];
    }
} //TC: O(amount * length of coins array), SC: O(amount)