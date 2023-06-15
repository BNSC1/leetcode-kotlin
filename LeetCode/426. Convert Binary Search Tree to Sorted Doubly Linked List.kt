class Solution {
    fun treeToDoublyList(root: Node?): Node? {
        if (root == null) return null
        
        var first: Node? = null
        var last: Node? = null

        fun link(node: Node?) {
            node?.let {
                link(it.left)

                if (last == null) {
                    first = it
                } else {
                    it.left = last
                    last.right = it
                }

                last = it

                link(it.right)
            }
        }

        link(root)

        first.left = last
        last.right = first
        return first
    }
}