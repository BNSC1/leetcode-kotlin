class WordDictionary() {
    val root = Node() //root node of the trie

    fun addWord(word: String) {
        var current = root //start from the root node

        word.forEach { char ->
            if (char !in current.children) { //if this char is not a child of the current node
                current.children[char] = Node() //new a node and add as child
            }
            current = current.children[char]!! //set the newly added/found child as current node
        }
        current.final = true //when the loop ends, set the end node as final char
    }

    fun search(word: String): Boolean {
        fun dfs(j: Int, node: Node): Boolean {
            var current = node

            for (i in j until word.length) { //from current char to the end of a word
                val c = word[i]
                if (c == '.') { //case "any char"
                    current.children.values.forEach { //for all children
                        if (dfs(i+1, it)) { //dfs for the next char, if a child matches the word
                            return true
                        }
                    }
                    return false
                } else { //case "specified char"
                    if (c !in current.children) { //if the char does not exist as children in the current node
                        return false
                    }
                    current = current.children[c]!! //set as current node if the char exists
                }
            }
            return current.final //return if it is the final char
        }
        return dfs(0, root) //start at the beginning
    }

}

data class Node(
    val children: HashMap<Char, Node> = HashMap<Char, Node>(), //store child nodes with key of a char
    var final: Boolean = false //flag for end char of a complete word
)

/**
 * Your WordDictionary object will be instantiated and called as such:
 * var obj = WordDictionary()
 * obj.addWord(word)
 * var param_2 = obj.search(word)
 */
