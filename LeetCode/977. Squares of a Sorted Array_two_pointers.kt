class Solution {
    fun sortedSquares(nums: IntArray): IntArray {
        val res = IntArray(nums.size)
        var start = 0
        var end = nums.size - 1

        for (i in nums.size-1 downTo 0) { //put largest abs number to right
            if (Math.abs(nums[start]) > Math.abs(nums[end])) {
                res[i] = nums[start++]
            } else {
                res[i] = nums[end--]
            }
        }

        res.forEachIndexed { i, it -> //square results
            res[i] = it * it
        }

        return res
    }
}