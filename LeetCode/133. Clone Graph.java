/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        Map<Node, Node> map = new HashMap<>(); //old node: new node
        
        class H {
            Node dfs(Node oldNode) {
                if (oldNode == null) return oldNode;
                if (map.containsKey(oldNode)) {
                    return map.get(oldNode);
                }
                Node newNode = new Node(oldNode.val);
                map.put(oldNode, newNode);

                for (Node node : oldNode.neighbors) {
                    newNode.neighbors.add(dfs(node));
                }
                return newNode;
            }
        }


        return new H().dfs(node);
    }
} //TC: O(n+e) SC: O(n), where n is the node count, e is the edge count