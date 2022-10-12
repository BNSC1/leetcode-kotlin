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
    var res = 0

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        depth(root)
        return res
    }

    fun depth(root: TreeNode?): Int = root?.let { //if the node is null, return 0
        val left = depth(it.left) //depth of the left side
        val right = depth(it.right) //depth of the right side

        res = Math.max(res, left+right) //if the left and right depth combined is greater than current result, replace the result
        Math.max(left, right) + 1 //return the side with greater depth and +1(for current depth)
    } ?: 0
}
