class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val n1 = nums1.size
        val n2 = nums2.size
        if (n1 > n2) return findMedianSortedArrays(nums2,nums1)
        val total = n1 + n2
        val half = (total + 1) / 2

        var low = 0
        var high = n1 - 1
        
        while (true) {
            val cut1 = if (high < 0) -1 else (low + high) / 2
            val cut2 = half - cut1 - 2
            val l1 = if (cut1 < 0) Int.MIN_VALUE else nums1[cut1]
            val l2 = if (cut2 < 0) Int.MIN_VALUE else nums2[cut2]
            val r1 = if (cut1 + 1 > n1 - 1) Int.MAX_VALUE else nums1[cut1 + 1]
            val r2 = if (cut2 + 1 > n2 - 1) Int.MAX_VALUE else nums2[cut2 + 1]

            if (r1 >= l2 && r2 >= l1) {
                return if (total % 2 == 0) (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0
                else Math.max(l1, l2) * 1.0
            }
            if (l1 > r2) high = cut1 - 1
            else low = cut1 + 1
        }
    }
}
/* 
Here's the intuition that helped me understand this. In this problem, we are searching for the "correct partition" in an array, such that,
1. Number of elements in the merged array is (m+n) // 2
2. All the elements in the left partition of both the arrays are lesser than or equal to all the elements in the right partition of both the arrays
3. If l1 > r2 --- shrink the partition
4. If l2 > r1 --- increase the partition

How do we know we can apply Binary search?
- We have a rule which can tell us if we should move to the right or to the left in the solution space

Here binary search can be run on any of the arrays, but we choose to run on the smaller one as it's more efficient.
*/