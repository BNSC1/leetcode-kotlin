class TrieNode() {
    val childs = HashMap<Char,TrieNode>() //map child(ren) of this trie node
    var isEnd = false //should be true if this node is end of a word
}


class Trie() {
    private val root = TrieNode() //the root node for trie tree

    fun insert(word: String) {
        var node = root //start with root node
        word.forEach {
            if (it !in node.childs) {
                node.childs[it] = TrieNode() //if this char does not exist as child node to current node, create new one and add it
            }
            node = node.childs[it]!! //switch current node to the newly added or existing node
        }
        node.isEnd = true //mark the node of last char as end of a word
    }

    fun search(word: String): Boolean {
        var node = root
        word.forEach {
            if (it !in node.childs) { //if this char does not exist as child node to current node, return false
                return false
            }
            node = node.childs[it]!!
        }
        return node.isEnd //if the for loop is done and the last node is also the end node, return true
    }

    fun startsWith(prefix: String): Boolean {
        var node = root
        prefix.forEach {
            if (it !in node.childs) { //if this char does not exist as child node to current node, return false
                return false
            }
            node = node.childs[it]!!
        }
        return true //if the for loop is done, return true
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */
