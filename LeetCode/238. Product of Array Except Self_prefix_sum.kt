class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val res = IntArray(nums.size) {1} //elements have init value 1

        var prefix = 1
        for (i in 0 until nums.size) {
            res[i] = prefix //current element is the product of element(s) before it
            prefix *= nums[i] //multiply the prefix for the next element
        }
        var postfix = 1
        for (i in nums.size - 1 downTo 0) {
            res[i] *= postfix //current element is multiplied by the product of element(s) after it
            postfix *= nums[i] //multiply the postfix for the previous element
        }
        return res
    }
}
