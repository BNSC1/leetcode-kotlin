//Not 100% sure if it works because I don't have LeetCode Premium :(
class TreeNode(val `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun verticalOrder(root: TreeNode): List<List<Int>> {
        var start = 0
        var end = 0
        val map = HashMap<Int, MutableList<Int>>().withDefault {mutableListOf()} //level: nums at current level
        
        fun dfs(node: TreeNode?, level: Int = 0) {
            node?.apply {
                start = level.coerceAtMost(start)
                end = level.coerceAtLeast(end)

                map[level] = map.getValue(level).apply { add(`val`) }
                dfs(left, level-1)
                dfs(right, level+1)
            }
        }
        dfs(root)

        val res = mutableListOf<List<Int>>()
        for (i in start..end) {
            res.add(map[i]!!)
        }

        return res
    }
}