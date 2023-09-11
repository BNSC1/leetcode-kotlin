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
    fun goodNodes(root: TreeNode): Int {
        var res = 0
        fun findGood(node: TreeNode? = root, max: Int = root.`val`) {
            if (node == null) return
            var curMax = max
            if (node.`val` >= curMax) {
                curMax = node.`val`
                res++
            }
            findGood(node.left, curMax)
            findGood(node.right, curMax)
        }
        findGood()
        return res
    }
}