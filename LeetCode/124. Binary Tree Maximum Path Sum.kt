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
    fun maxPathSum(root: TreeNode?): Int {
        var res = root!!.`val`
        fun dfs(node: TreeNode?): Int = node?.run {
            val leftMax = dfs(left).coerceAtLeast(0)
            val rightMax = dfs(right).coerceAtLeast(0)

            res = (`val` + leftMax + rightMax).coerceAtLeast(res) //try path that walks only from current node, its left, to its right
            `val` + Math.max(leftMax, rightMax) //return path with greater value to the parent
        } ?: 0

        dfs(root)
        return res
    }
}