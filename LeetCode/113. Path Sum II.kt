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
    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>() //list of paths that sums to target sum

        fun findPaths(node: TreeNode?, diff: Int, currentPath: MutableList<Int>) {
            node?.let { //if the node is not null
                currentPath.add(it.`val`) //add the node to current path
                if (it.`val` == diff &&
                    it.left == null &&
                    it.right == null) { //if the path sums to target sum, and already transversed to a leaf
                        res.add(ArrayList(currentPath)) // add the path to result
                    }
                
                val newDiff = diff - it.`val`
                it.left?.let { n -> //if left child is not null
                    findPaths(it.left, newDiff, currentPath) //new recursion with the child with diff subtracted
                    currentPath.removeAt(currentPath.lastIndex) //clean up the added node for the next path
                }
                it.right?.let { n ->
                    findPaths(it.right, newDiff, currentPath)
                    currentPath.removeAt(currentPath.lastIndex)
                }
            }
        }
        findPaths(root, targetSum, mutableListOf<Int>())
        return res
    }
}