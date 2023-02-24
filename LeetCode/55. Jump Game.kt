class Solution {
    fun canJump(nums: IntArray): Boolean {
        var goal = nums.size-1 //initially the goal is the last index

        for (i in nums.size-1 downTo 0) {
            if (i + nums[i] >= goal) { //if current index reaches the goal
                goal = i //shift goal index to that because it eventually reaches the end
            }
        }
        return goal == 0 //if the goal gets shifted to 0, it is true that reaching the last index is possible
    }
}