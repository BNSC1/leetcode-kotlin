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
    fun isSymmetric(root: TreeNode?): Boolean {
        val q = LinkedList<Array<TreeNode?>>()
        root?.let {
            q.add(arrayOf(it.left, it.right)) //add pair of left right nodes for comparing
        }

        while (q.isNotEmpty()) {
            val tmp = q.pop()
            val l = tmp[0]
            val r = tmp[1]

            if (l == null && r == null) continue //if both nodes are null, skip to next loop
            if (l == null || r == null) return false //if only 1 node if null, return false
            if (l.`val` == r.`val`) { //if they have the same value, add next pairs to queue
                q.add(arrayOf(l.left, r.right))
                q.add(arrayOf(l.right, r.left))
            } else return false //otherwise return false
        }
        return true //if none false conditions are met, return true
    } // TC: O(node count), SC: O(node count)
}
