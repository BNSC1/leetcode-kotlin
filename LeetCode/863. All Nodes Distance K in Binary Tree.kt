/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun distanceK(root: TreeNode?, target: TreeNode?, k: Int): List<Int> {
        val graph = HashMap<TreeNode, MutableList<TreeNode>>() //node: neighbor nodes
        val visited = HashSet<TreeNode>()

        fun buildGraph(node: TreeNode?) {
            node?.let { node ->
                node.left?.let {
                    graph[node] = graph[node]?.apply { add(it) } ?: mutableListOf(it)
                    graph[it] = graph[it]?.apply { add(node) } ?: mutableListOf(node)
                    buildGraph(it)
                }

                node.right?.let {
                    graph[node] = graph[node]?.apply { add(it) } ?: mutableListOf(it)
                    graph[it] = graph[it]?.apply { add(node) } ?: mutableListOf(node)
                    buildGraph(it)
                }
            }
        }
        
        fun bfs(node: TreeNode?): LinkedList<TreeNode> {
            val queue = LinkedList<TreeNode>().apply {
                add(target!!)
            }
            repeat(k) { //levels
                repeat(queue.size) { //current level of nodes
                    val node = queue.remove()
                    visited.add(node)
                    graph[node]?.forEach { nextLevelNode ->
                        if (nextLevelNode !in visited) {
                            queue.add(nextLevelNode)
                        }
                    }
                }
            }
            return queue
        }

        buildGraph(root)
        return bfs(target!!).map { it.`val` }
    }
}