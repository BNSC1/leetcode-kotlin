class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val res = IntArray(nums.size) {1} //int array with size of nums size, and all elements have init value 1

        var prefix = 1
        for (i in 0 until nums.size) {
            res[i] = prefix //set previous prefix result to current element
            prefix *= nums[i] //multiply prefix sum with current element
        }
        var postfix = 1
        for (i in nums.size - 1 downTo 0) {
            res[i] *= postfix //multiply previous postfix result with current element
            postfix *= nums[i] //multiply postfix sum with current element
        }
        return res
    }
}
