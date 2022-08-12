/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        var current = root
        
        while (current != null) { //since in a binary search tree, the number on the left node is always smaller than the one on the right node and the parent node
            if (current.`val` > p!!.`val` && current.`val` > q!!.`val`) { //when the current node is larger than both p and q, it is clear they are on the left side, so we swap the current node to the left node
                current = current.left
            } else if (current.`val` < p!!.`val` && current.`val` < q!!.`val`) { //swap to the right node if the opposite is true
                current = current.right
            } else return current //when both p and q are no longer bigger or smaller than the current node, it is the lowest common ancestor node
        }
        return current
    }
}