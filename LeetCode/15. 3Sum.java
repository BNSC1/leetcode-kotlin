class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int size = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int first = 0; first < size; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) continue;
            int second = first + 1;
            int third = size - 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                if (sum > 0) third--;
                else if (sum < 0) second++;
                else {
                    res.add(Arrays.asList(nums[first], nums[second], nums[third]));
                    do { second++; } while (nums[second] == nums[second-1] && second < size - 1);
                }
            }
        }
        return res;
    }
} // TC: O(n^2 + nlogn) because we need to traverse the whole list n times, and sorting is involved SC: O(1)