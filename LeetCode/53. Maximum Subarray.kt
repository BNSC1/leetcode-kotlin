class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var res = Int.MIN_VALUE
        var currSum = 0
    
    nums.forEach {
        currSum += it //add current element to current sum
        res = Math.max(res, currSum) //if current sum is larger then set it as the answer
        if (currSum < 0) currSum = 0 //reset to 0 if it is negative because we will discard that subarray
        //if an array has only negative elements, we will take 1 element with the largest number as the largest sum
    }
    return res
    }
}