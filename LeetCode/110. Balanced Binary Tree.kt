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
    fun isBalanced(root: TreeNode?): Boolean {
        return balance(root).isBalanced
    }
    
    fun balance(root: TreeNode?): Res =
        root?.let { //if the node is not null
            val left = balance(root.left) //initate left recursion
            val right = balance(root.right) //initate right recursion
            val isBalanced = left.isBalanced && right.isBalanced && Math.abs(left.depth - right.depth) <= 1 //if both children return they are balance and their depth difference is within 1, the subtree is balanced
            Res(isBalanced, Math.max(left.depth, right.depth)+1)  //return balanced and depth, max from child nodes, plus 1 for proceeding to the next depth
        } ?: Res(true) //return balanced and depth 0 if the node is null
}

class Res(val isBalanced: Boolean, val depth: Int = 0) //for balance function to return both isBalanced and depth