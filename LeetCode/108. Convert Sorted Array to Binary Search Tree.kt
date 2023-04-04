/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        fun sort(start: Int = 0, end: Int = nums.size - 1): TreeNode? {
            if (start <= end) {
                val mid = (start + end) / 2
                return TreeNode(nums[mid]).apply {
                    left = sort(start, mid - 1)
                    right = sort(mid + 1, end)
                }
            }
            return null
        }
        return sort()
    }
}