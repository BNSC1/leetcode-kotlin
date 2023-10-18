class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        // sorting
        nums.sort()
        val res = mutableListOf<List<Int>>()
        val cur = mutableListOf<Int>()
        res.add(mutableListOf())
        fun subsets(i: Int = 0, isPicked: Boolean = true) {
            // base case
            if (i >= nums.size) {
                return
            }
            val `val` = nums[i]
            // duplicate checking (convert && to ||)
            if (isPicked || nums[i - 1] != nums[i]) {
                // pick
                cur.add(`val`)
                subsets(i + 1, true)
                res.add(cur.toList()) // add to the result list
                cur.removeLast()
            }
            // not pick
            subsets(i + 1, false)
        }
        subsets()
        return res
    }
}