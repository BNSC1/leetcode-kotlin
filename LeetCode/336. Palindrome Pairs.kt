class Solution {
    fun palindromePairs(words: Array<String>): List<List<Int>> {
        val wordMap = HashMap<String, Int>() //word : index
        val set = TreeSet<Int>() //length
        words.forEachIndexed { i, word ->
            wordMap[word] = i
            set.add(word.length)
        }
        val res = mutableListOf<List<Int>>()
        words.forEachIndexed { i, word ->
            val currWordLength = word.length

            val reverse = StringBuilder(word).reverse().toString()
            if (reverse in wordMap && wordMap[reverse]!! != i) { //find mirrored word
                res.add(listOf(i, wordMap[reverse]!!))
            }
            for (length in set) {
                if (length == currWordLength) break
                if (isPalindrome(reverse, 0, currWordLength - 1 - length)) {
                    val s1 = reverse.substring(currWordLength - length)
                    if (s1 in wordMap) res.add(listOf(i, wordMap[s1]!!))
                }
                if (isPalindrome(reverse, length, currWordLength - 1)) {
                    val s2 = reverse.substring(0, length)
                    if (s2 in wordMap) res.add(listOf(wordMap[s2]!!, i))
                }
            }
        }
        return res
    }

    private fun isPalindrome(s: String, left: Int, right: Int): Boolean {
        var left = left
        var right = right
        while (left < right) {
            if (s[left++] != s[right--]) return false
        }
        return true
    }
}