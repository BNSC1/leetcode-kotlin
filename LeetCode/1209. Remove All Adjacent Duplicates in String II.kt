class Solution {
    fun removeDuplicates(s: String, k: Int): String {
        val subs = LinkedList<CharMap>()
        var start = 0
        s.forEach { c ->
            if (subs.isNotEmpty() && subs.peekLast().char == c) {
                subs.peekLast().cnt++
            } else subs.add(CharMap(c))
            if (subs.peekLast().cnt == k) subs.pollLast()
        }
        val sb = StringBuilder()
        while (subs.isNotEmpty()) {
            val sub = subs.poll()
            repeat(sub.cnt) {
                sb.append(sub.char)
            }
        }
        return sb.toString()
    }
}
class CharMap(val char: Char, var cnt: Int = 1)