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
    fun rightSideView(root: TreeNode?): List<Int> {
        val res = mutableListOf<Int>()
        val q: Queue<TreeNode?> = LinkedList<TreeNode?>(listOf(root))

        while (q.isNotEmpty()) {
            var right: TreeNode? = null //the "latest" node from the queue

            for (i in 0 until q.size) { //loop nodes in current level
                q.poll()?.let { node -> //if popped node is not null
                    right = node //set current right node to this popped node
                    q.add(node.left)
                    q.add(node.right) //add children to next level of queue
                }
            }
            right?.let { //if the latest node is not null
                res.add(it.`val`) //add its value to the result
            }
        }
        return res
    }
}
