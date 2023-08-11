class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int n : nums) {
            sum += n;
            res = Math.max(res, sum);
            if (sum < 0) sum = 0;
        }
        return res;
    }
} //TC: O(n), SC: O(1)