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
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        if (preorder.isEmpty() || inorder.isEmpty()) return null //return the node as null if there are no more elements

        val root = TreeNode(preorder[0]) //take first preorder element as root
        val mid = inorder.indexOf(preorder[0]) //get the index of where the root is in inorder array
        root.left = buildTree(
            preorder.sliceArray(1..mid),
            inorder.sliceArray(0 until mid)) //take left subtree, skip the root node

        root.right = buildTree(
            preorder.sliceArray(mid+1 until preorder.size),
            inorder.sliceArray(mid+1 until inorder.size)) //take right subtree, skip the root node
        return root
    }
}
