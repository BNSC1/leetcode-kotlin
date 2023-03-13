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
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        val q = LinkedList<TreeNode>()
        root?.let { //if root is not null
            q.add(it)
        }
        while (q.isNotEmpty()) { //do until the queue is empty (reached bottom or the root is null)
            val level = mutableListOf<Int>() //current level of values
            repeat(q.size) { //repeat current level of elements
                val n = q.poll() //current node
                level.add(n.`val`)

                n.left?.let {
                    q.add(it)
                }
                n.right?.let { //if the left/right node of the current node is not null
                    q.add(it) //add it to the queue for the next level iteration
                }
            }
            if (res.size % 2 == 1) level.reverse() //if the level we are adding is going to be in even index, reverse it
            res.add(level)
        }

        return res
    }
}