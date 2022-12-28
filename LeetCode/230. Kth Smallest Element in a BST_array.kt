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
        val array = IntArray(k) //initiated with size of k
        var curr = 0 //pointer for the array
        fun dfs(node: TreeNode?) {
            node?.let { //if the node if not null
                dfs(it.left) //recursion for left node first
                if (curr < k) { //when the array is not over capacity
                    array[curr++] = it.`val` //add current node value to the array
                    dfs(it.right) //after adding the node value, start right node recursion
                }
            }
        }
        dfs(root)
        return array.last() //after the recursion, the numbers should be added in ascending order, return the last number in the array as its size is limited
    }
}

