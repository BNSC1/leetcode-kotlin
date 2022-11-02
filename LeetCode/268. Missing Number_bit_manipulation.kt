class Solution {
    fun missingNumber(nums: IntArray): Int {
        var res = 0

        nums.forEachIndexed { i, it ->
            res = res xor it xor i
        } //the idea is that if index has paired num, they will be offset in bit manipulation, revealing index that has no pair

        return res xor nums.size //exculde array size as well
    } //TC: O(n), SC: O(1)
}
