/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var neighbors: ArrayList<Node?> = ArrayList<Node?>()
 * }
 */

class Solution {
    val newMap = HashMap<Node, Node>() //old node:new node
    fun cloneGraph(node: Node?): Node? {
        return dfs(node)
    }

    fun dfs(node: Node?): Node? {
        if (node != null) {
            if(node in newMap) return newMap[node] //if node has the same one in the map, return the copied node

            val cp = Node(node.`val`) //copy a new node
            newMap[node] = cp //if not, add the node and link the newly copied node with the old node
            for (n in node.neighbors) { //loop the neighbor nodes of the old node
                cp.neighbors.add(dfs(n)) //add copied neighbors to the copy node
            }
            return cp
        }
        return null //do nothing and return null if the node is null
    }
}
