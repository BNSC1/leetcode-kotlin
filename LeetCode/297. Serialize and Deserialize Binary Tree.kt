/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

 class Codec() {
	// Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?) = root?.run {
        val sb = StringBuilder()
        fun dfs(root: TreeNode?) {
            root?.run {
                sb.append(",${`val`}")
                dfs(left)
                dfs(right)
            } ?: sb.append(", ")
        }
        
        sb.append(`val`)
        dfs(left)
        dfs(right)
        sb.toString()
    } ?: " "

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        val arr = data.split(',').toTypedArray()
        var i = 0
        fun dfs(): TreeNode? {
            if (arr[i] == " ") {
                i++
                return null
            }
            return TreeNode().apply {
                `val` = arr[i].toInt()
                i++
                left = dfs()
                right = dfs()
            }
        }
        return dfs()
    }
}

/**
 * Your Codec object will be instantiated and called as such:
 * var ser = Codec()
 * var deser = Codec()
 * var data = ser.serialize(longUrl)
 * var ans = deser.deserialize(data)
 */