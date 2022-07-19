class Solution {
    fun isPalindrome(s: String): Boolean {
        val sb = StringBuilder()

        s.forEach {
            if (it >= 'A' && it <= 'Z') sb.append(it + 32)
            else if (it >= 'a' && it <= 'z') sb.append(it)
            else if (it >= '0' && it <= '9') sb.append(it)
        }

        val str = sb.toString()
        var h = 0
        var t = str.length-1

        while(h < t) {
            if (str[h] != str[t]) return false
            h++
            t--
        }
        return true
    }
}
