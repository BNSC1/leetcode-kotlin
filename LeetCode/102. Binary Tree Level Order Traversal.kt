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
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        val queue = LinkedList<TreeNode?>() //store nodes to be processed in order
        queue.add(root) //root is the first node to be processed

        while (queue.isNotEmpty()) { //while the queue isn't empty
            val size = queue.size
            val lvl = mutableListOf<Int>() //values of nodes of current level
            for (i in 0 until size) { //loop the queue by current size
                queue.pollFirst()?.let { //if the popped node isn't null
                    lvl.add(it.`val`) //add its value to lvl
                    queue.add(it.left)
                    queue.add(it.right) //add left and right nodes to the queue for next level
                }
            }
            if (lvl.isNotEmpty()) res.add(lvl) //if lvl isn't empty then add it to the result
        }
        return res
    }
}
