class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        var res = 0
        var diff = Int.MAX_VALUE

        for (first in 0 until nums.size) {
            var second = first + 1
            var third = nums.size - 1

            while (second < third) {
                val sum = nums[first] + nums[second] + nums[third]
                if (diff > Math.abs(sum - target)) {
                    diff = Math.abs(sum - target)
                    res = sum
                }

                if (sum == target) return sum
                else if (sum > target) third-- //shift the third pointer for possible smaller result
                else second++ //shift the second pointer for possible greater result
            }
        }
        return res
    }
}