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
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val list = mutableListOf<Int>()
        fun dfs(node: TreeNode?) {
            node?.let { //if the node if not null
                dfs(it.left) //recursion for left node first
                list.add(it.`val`) //add current node value to the list
                dfs(it.right) //after adding the node value, start right node recursion
            }
        }
        dfs(root)
        return list[k-1] //after the recursion, the numbers should be added in ascending order, return the number in k-1 index because k is 1-indexed
    }
}
