class Solution {
    fun singleNumber(nums: IntArray): Int {
        var res = 0

        nums.forEach {
            res = res xor it // if there is a num not paired, the result will become it
        }
        return res
    }
} // TC: O(n), SC: O(1)
