class Solution {
    fun compress(chars: CharArray): Int {
        var cur = 0
        var tail = 0
        while (tail < chars.size) {
            val head = tail
            while (tail + 1 < chars.size && chars[tail + 1] == chars[tail])
                tail++ //move tail to end of group of same chars
            chars[cur++] = chars[tail] //add char
            if (head != tail) { //more than 1 same char
                (tail - head + 1).toString().forEach { digit ->
                    chars[cur++] = digit //add digit(s)
                }
            }
            tail++
        }
        return cur
    }
}