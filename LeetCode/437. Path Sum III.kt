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
    fun pathSum(root: TreeNode?, target: Int): Int {
        var res = 0
        val cache = hashMapOf<Long, Int>(target.toLong() to 1) //sum: path count, with base case "1 path to target sum"

        fun sum(node: TreeNode?, prev: Long = 0L) {
            node?.let {
                val curr = (prev + node.`val`).toLong()
                res += cache[curr] ?: 0 //if this path/subpath leads to the target, add to the result
                cache[curr + target] = (cache[curr + target] ?: 0) + 1 //add subpath target sum
                sum(node.left, curr)
                sum(node.right, curr)
                cache[curr + target] = cache[curr + target]!! - 1 //revert the cache because the subpath target sum is not available for other branches
            }
        }

        sum(root)
        return res
    }
}