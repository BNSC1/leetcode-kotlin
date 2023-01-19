class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val longest = IntArray(nums.size) { 1 }
        for (i in nums.size - 2 downTo 0) { //start at second last index and go backwards
            for (j in i + 1 until nums.size) { //check if index after i has greater value
                if (nums[i] < nums[j]) {
                    longest[i] = Math.max(longest[i], longest[j] + 1)
                }
            }
        }
        return longest.max()!!
    }
}
