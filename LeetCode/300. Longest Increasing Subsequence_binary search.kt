class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val sub = mutableListOf<Int>()
        nums.forEach { num ->
            if (sub.isEmpty() || sub.last() < num) {
                sub.add(num)
            } else {
                val bin = sub.binarySearch(num)
                val i = if (bin >= 0) bin else -bin - 1
                sub[i] = num
            }
        }
        return sub.size
    } //TC: O(nlogn) SC: O(n)
}