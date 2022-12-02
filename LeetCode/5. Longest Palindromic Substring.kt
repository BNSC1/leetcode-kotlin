class Solution {
    fun longestPalindrome(s: String): String {
        val res = StringBuilder()


        for(i in 0 until s.length) {
            var l = i
            var r = i //check odd palindrome
            while(l >= 0 && r < s.length && s[l] == s[r]) { //while left and right pointers are not out of bounds and they have matching char
                if (r - l + 1 > res.length) { //if pointed substring is longer than current result
                    res.clear()
                    res.append(s.substring(l,r+1)) //replace the result with pointed substring
                }
                l--
                r++ //move pointers outwards
            }

            l = i
            r = i + 1 //check even palindrome
            while(l >= 0 && r < s.length && s[l] == s[r]) {
                if (r - l + 1 > res.length) {
                    res.clear()
                    res.append(s.substring(l,r+1))
                }
                l--
                r++
            }
        }
        return res.toString()
    }
}
