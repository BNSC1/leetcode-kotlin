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
    fun isValidBST(r: TreeNode?): Boolean {
        var curr = r
        curr?.let {
            val st = Stack<TreeNode>()
            var prev: TreeNode? = null

            while (curr != null || st.isNotEmpty()) {
                while (curr != null) { //while the curr node is not null, push curr node and its left node to the stack
                    st.push(curr)
                    curr = curr!!.left
                }
                curr = st.pop() //pop when root is null
                if (prev != null && curr!!.`val` <= prev.`val`) return false //when current value is less or equal to previous one, return false
                prev = curr //set as previously visited node
                curr = curr!!.right //switch curr node to right node
            }
        }
        return true
    }
}
