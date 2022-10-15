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
    fun maxDepth(root: TreeNode?): Int {
        val stack = Stack<TreeNode>()
        val num = Stack<Int>()
        var res = 0

        stack.add(root)
        num.add(1)

        while (stack.isNotEmpty()) {
            stack.pop()?.let { node -> // if the popped node is not null
                var tmp = num.pop()
                res = Math.max(res, tmp) // pop stored depth num and set as the result if it is greater

                node.right?.let {
                    stack.add(it)
                    num.add(tmp+1)
                } // add right node to the stack, and add current depth num+1 if it is not null

                node.left?.let {
                    stack.add(it)
                    num.add(tmp+1)
                } // add left node to the stack, and add current depth num+1 if it is not null
            }
        }
        return res
    }
}
