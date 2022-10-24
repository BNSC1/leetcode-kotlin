class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var res = Int.MIN_VALUE //make result starting as min value so negative value can be a result
        var tmp = 0

        nums.forEach {
            tmp += it //add up to tmp value
            res = Math.max(tmp, res) //set tmp to be the new result if tmp is larger than the current one
            if (tmp < 0) tmp = 0 //if the tmp ended up being negative, discard it
        }
        return res
    }
}
