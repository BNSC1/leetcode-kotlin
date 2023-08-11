class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = nums.clone();
        int size = nums.length;
        int prefix = 1;
        for (int i=0; i<size; i++) {
            res[i] = prefix;
            prefix *= nums[i];
        }
        int postfix = 1;
        for (int i=size-1; i>=0; i--) {
            res[i] *= postfix;
            postfix *= nums[i];
        }
        return res;
    }
} //TC: O(2n), SC: O(1), where n is the length of nums array