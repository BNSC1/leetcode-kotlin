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
    fun widthOfBinaryTree(root: TreeNode?): Int {
        var res = 0
        val leftmost = HashMap<Int, Int>() //depth: leftmost position offset

        fun getWidth(root: TreeNode?, depth: Int, pos: Int) {
            root?.let { //if the node exists
                leftmost.putIfAbsent(depth, pos) //put the first(leftmost in current depth) position offset to the current depth, for case where leftmost nodes are null
                res = Math.max(res, pos-leftmost[depth]!!+1) //update result if the current position-leftmost offset is greater
                getWidth(it.left, depth+1, pos*2)
                getWidth(it.right, depth+1, pos*2+1) //to the next depth
            }
        }

        getWidth(root, 0, 0)
        return res
    }
}