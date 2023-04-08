class Solution {
    fun findMin(nums: IntArray): Int {
        var res = Int.MAX_VALUE
        var l = 0
        var r = nums.size - 1

        while (l <= r) {
            if (nums[l] < nums[r]) {
                res = Math.min(res, nums[l])
                break
            }

            val m = (l + r) / 2
            res = Math.min(res, nums[m])
            if (nums[m] >= nums[l]) { //pivot could be on the right
                l = m + 1
            } else { //pivot could be on the left
                r = m - 1
            }
        }
        return res
    }
}