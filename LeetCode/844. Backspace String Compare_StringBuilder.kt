class Solution {
    fun backspaceCompare(s: String, t: String): Boolean {
        val sbS = StringBuilder()
        val sbT = StringBuilder()
        var bs = 0

        for (i in s.length-1 downTo 0) {
            if (s[i] == '#') bs++ //if the char is a backspace, add backspace count by 1
            else if (bs > 0) bs-- //if the char isn't a backspace but there is a backspace, subtract backspace count by 1
            else sbS.append(s[i])
        }
        bs = 0 // reset backspace count in case there are more backspaces than actual chars from previous loop

        for (i in t.length-1 downTo 0) {
            if (t[i] == '#') bs++
            else if (bs > 0) bs--
            else sbT.append(t[i])
        }

        return sbS.toString() == sbT.toString() //compare if both result strings are the same
    } // TC: O(s.length + t.length), SC: O(s.length + t.length) (used 2 string builders to store compute results)
}
