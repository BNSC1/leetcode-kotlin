class Trie {
    Node root = new Node();

    public Trie() {} //SC: O(total number of inserted characters)
    
    public void insert(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.childs.containsKey(c)) {
                Node child = new Node();
                cur.childs.put(c, child);
            }
            cur = cur.childs.get(c);
        }
        cur.isEnd = true;
    } //TC: O(word length)
    
    public boolean search(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (cur.childs.containsKey(c)) {
                cur = cur.childs.get(c);
            } else return false;
        }
        return cur.isEnd;
    } //TC: O(word length)
    
    public boolean startsWith(String prefix) {
        Node cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.childs.containsKey(c)) {
                cur = cur.childs.get(c);
            } else return false;
        }
        return true;
    } //TC: O(prefix length)
}
class Node {
    HashMap<Character, Node> childs = new HashMap<>();
    boolean isEnd = false;
    Node() {}
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */