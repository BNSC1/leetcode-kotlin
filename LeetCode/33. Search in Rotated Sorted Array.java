class Solution {
    public int search(int[] nums, int target) {
        int size = nums.length;
        int start = 0;
        int end = size - 1;
        while (start <= end) {
            int mid = (end + start) / 2;
            if (nums[mid] == target) return mid;
            if (nums[start] > nums[mid]) {
                if (target > nums[end] ||
                    target < nums[mid]) end = mid - 1;
                else start = mid + 1;
            } else {
                if (target < nums[start] ||
                    target > nums[mid]) start = mid + 1;
                else end = mid - 1;
            }
        }

        return -1;
    }
} //TC: O(logn), SC: O(1)