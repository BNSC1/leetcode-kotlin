class Solution {
    fun findLength(nums1: IntArray, nums2: IntArray): Int {
        val size1 = nums1.size
        val size2 = nums2.size
        if (size1 < size2) return findLength(nums2, nums1)
        var dp = IntArray(size2 + 1)
        var prevDp = IntArray(size2 + 1)
        var res = 0

        for (i in 1..size1) {
            for (j in 1..size2) {
                if (nums1[i-1] == nums2[j-1]) dp[j] = prevDp[j-1] + 1
                else dp[j] = 0
                res = maxOf(res, dp[j])
            }
            val tmp = dp
            dp = prevDp
            prevDp = tmp
        }
        return res
    }
}