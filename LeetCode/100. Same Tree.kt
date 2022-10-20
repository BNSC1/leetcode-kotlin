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
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        val stackP = Stack<TreeNode?>()
        val stackQ = Stack<TreeNode?>()

        stackP.add(p)
        stackQ.add(q) //start with root nodes

        while (stackP.isNotEmpty() && stackQ.isNotEmpty()) {
            val tmpP = stackP.pop()
            val tmpQ = stackQ.pop()

            if (tmpP == null && tmpQ == null) continue //when both tmpP and tmpQ are empty, skip to the next nodes
            if (tmpP == null || tmpQ == null) return false //when only 1 node is null, return false
            if (tmpP.`val` == tmpQ.`val`) { //when both nodes are not null, compare their values
                tmpP?.apply {
                    stackP.add(right)
                    stackP.add(left)
                }
                tmpQ?.apply {
                    stackQ.add(right)
                    stackQ.add(left)
                } //add their left and right nodes to respective stacks, if they have the same value
            } else return false //if the values differs, return false
        }

        return true
    } //TC: O(node count), SC: O(tree height)
}
