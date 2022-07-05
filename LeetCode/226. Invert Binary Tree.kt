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
    fun invertTree(root: TreeNode?): TreeNode? {
        return invert(root)
    }

    fun invert(root: TreeNode?): TreeNode? = //don't forget to specify return type if you are returning it as an expression, for edge cases like empty tree
        root?.apply { //"?.apply" for null check, if null, it will end up returning the node without further recursion
            val tmp = left
            left = right
            right = tmp //swap nodes

            invert(left)
            invert(right) //child nodes to recursive function
        }
}
