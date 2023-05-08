class Solution {
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val root = TrieNode()
        words.forEach {
            root.addWord(it)
        }

        val rows = board.size
        val cols = board[0].size

        val res = HashSet<String>()
        val visited = HashSet<Pair<Int,Int>>()

        fun dfs(r: Int, c: Int, node: TrieNode, word: StringBuilder) {
            val coord = Pair(r, c)
            if (r < 0 || c < 0 ||
                r >= rows || c >= cols ||
                board[r][c] !in node.children ||
                coord in visited) return
            
            visited.add(coord)
            val node = node.children[board[r][c]]!!
            word.append(board[r][c])
            if (node.isEnd) res.add(word.toString())

            dfs(r+1, c, node, StringBuilder(word))
            dfs(r-1, c, node, StringBuilder(word))
            dfs(r, c+1, node, StringBuilder(word))
            dfs(r, c-1, node, StringBuilder(word))
            visited.remove(coord)
        }

        repeat(rows) { r ->
            repeat(cols) { c ->
                dfs(r, c, root, StringBuilder())
            }
        }
        return res.toList()
    }
}
class TrieNode {
    var isEnd = false
    val children = HashMap<Char, TrieNode>()

    fun addWord(word: String) {
        var curr = this
        word.forEach { c ->
            if (c !in curr.children) { //prevent overwriting words with same prefix
                curr.children[c] = TrieNode()
            }
            curr = curr.children[c]!!
        }
        curr.isEnd = true
    }
}