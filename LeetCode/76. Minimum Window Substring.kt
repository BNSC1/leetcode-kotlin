class Solution {
    fun minWindow(s: String, t: String): String {
        val needFinds = HashMap<Char, Int>().also { map -> //char: need find count
            t.forEach { c ->
                map[c] = map[c]?.let {it + 1} ?: 1
            }
        }
        var minStart = 0
        var minLen = Int.MAX_VALUE
        var cnt = t.length
        var start = 0
        
        s.forEachIndexed { end, endChar ->
            if (endChar in needFinds && needFinds[endChar]!! > 0) cnt--
            needFinds[endChar] = needFinds[endChar]?.let {it - 1} ?: -1
            while (cnt == 0) {
                if (minLen > end - start + 1) {
                    minLen = end - start + 1
                    minStart = start
                }
                val startChar = s[start]
                needFinds[startChar] = needFinds[startChar]!! + 1
                if (startChar in needFinds && needFinds[startChar]!! > 0) cnt++
                start++
            }
        }
        return if (minLen == Int.MAX_VALUE) "" else s.substring(minStart until minStart+minLen)
    }
}