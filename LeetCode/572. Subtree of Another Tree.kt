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
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (subRoot == null) return true //already no more subtree nodes to check
        if (root == null) return false //already no more tree nodes to compare, meaning the tree does not include all subtree nodes

        if (findSub(root, subRoot)) return true //found matching subtree
        return isSubtree(root.left, subRoot) ||
               isSubtree(root.right, subRoot) //if not, continue to check with the node's children
    }

    fun findSub(root: TreeNode?, subRoot: TreeNode?): Boolean {
            if (root == null && subRoot == null) { //no more nodes to check
                return true
            }
            if (root != null && subRoot != null &&
                root.`val` == subRoot.`val`) { //if both trees have nodes to compare and has same node values
                    return findSub(root.left, subRoot.left) &&
                           findSub(root.right, subRoot.right) //continue to compare their children
            }
            return false
        }
}