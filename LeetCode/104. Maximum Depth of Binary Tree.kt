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
    fun maxDepth(root: TreeNode?): Int {
        return root?.run {
            Math.max(maxDepth(left), maxDepth(right)) +1 //take greater depth then add by 1 for current depth
        } ?: 0 //return 0 if the node is null
    }
}
