class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        var slow = 0

        for (fast in 0 until nums.size) { // loop until fast pointer is at the end of array
            if (nums[slow] != 0) { // move slow pointer if it is not pointing to 0
                slow++
            } else if (nums[fast] != 0) { // if slow pointer points to 0 and fast pointer doesn't, swap their value then move slow pointer
                val tmp = nums[slow]
                nums[slow] = nums[fast]
                nums[fast] = tmp
                slow++
            }
        }
    } // TC: O(nums.size), SC: O(1)
}
