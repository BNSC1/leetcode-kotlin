class Solution {
    //inorder: nodes on the left are always lesser, nodes on the right are always greater
    fun inorderSuccessor(root: TreeNode?, p: TreeNode?): TreeNode? {
        var root = root
        var successor: TreeNode? = null

        while (root != null) {
            if (p.`val` >= root.`val`) { //if the current node is lesser, iterate the right child node
                root = root!!.right
            } else { //if the current node is greater, take the node as successor and iterate the left child node
                successor = root
                root = root!!.left
            }
        }
        return successor
    }
}