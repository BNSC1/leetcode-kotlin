 class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val map = HashMap<Char, Int>() //char:latest index
        var head = 0
        var tail = 0

        var res = 0

        while (tail < s.length) { //loop until the tail index is over length of the string
            if (s[tail] in map) { //if current char is repeated
                head = Math.max(head, map[s[tail]]!!+1) //update the head index to the last repeated char index+1 if it is larger
            }
            map[s[tail]] = tail //update the char index to the latest one
            ++tail //increment for the tail index
            res = Math.max(res, tail-head) //update the result if current length is larger
        }
        return res
    }
}
