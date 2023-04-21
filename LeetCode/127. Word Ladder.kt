class Solution {
    fun ladderLength(begin: String, end: String, list: List<String>): Int {
        if (end !in list) return 0

        val neighbors = HashMap<String, MutableList<String>>().withDefault { mutableListOf() } //pattern: matched strings
        val allWords = mutableListOf<String>().apply {
            add(begin)
            addAll(list)
        }

        allWords.forEach { word ->
            word.forEachIndexed { wildcardIndex, _ ->
                val pattern = getPattern(word, wildcardIndex)
                neighbors[pattern] = neighbors.getValue(pattern).apply {add(word)}
            }
        } //add words that matches the pattern

        val visited = mutableSetOf<String>(begin)
        val queue: Queue<String> = LinkedList<String>().apply {add(begin)}
        var level = 1
        while (queue.isNotEmpty()) {
            var neighborsAtCurrLevel = queue.size
            repeat(neighborsAtCurrLevel) {
                val word = queue.poll()
                if (word == end) return level
                word.forEachIndexed { wildcardIndex, _ ->
                    val pattern = getPattern(word, wildcardIndex)
                    neighbors[pattern]!!.forEach { neighborWord -> //add words to the next level by pattern
                        if (neighborWord !in visited) {
                            visited.add(neighborWord)
                            queue.add(neighborWord)
                        }
                    }
                }
            }
            level++
        }
        return 0
    }

    fun getPattern(word: String, wildcardIndex: Int) = word.substring(0 until wildcardIndex) + '*' + word.substring(wildcardIndex+1 until word.length)
}