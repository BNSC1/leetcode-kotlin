class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        nums.sort()

        repeat(nums.size) { first ->
            if (first > 0 && nums[first] == nums[first-1]) return@repeat

            var second = first + 1
            var third = nums.size - 1
            while (second < third) {
                val sum = nums[first] + nums[second] + nums[third]
                if (sum > 0) third--
                else if (sum < 0) second++
                else {
                    res.add(listOf(nums[first], nums[second], nums[third]))
                    do {
                        second++
                    } while (nums[second] == nums[second - 1] && second < nums.size - 1)
                }
            }
        }
        return res
    }
}