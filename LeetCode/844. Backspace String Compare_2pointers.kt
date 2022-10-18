class Solution {
    fun backspaceCompare(s: String, t: String): Boolean {
        var sptr = s.length - 1
        var tptr = t.length - 1 // start pointers at the end of their strings
        var bs: Int

        while (true) {
            // when met a backspace, add backspace count by 1 and move the pointer to left by 1
            // or when there is a backspace, move the pointer to left by 1 and reduct the backspace by 1
            bs = 0
            while (sptr >= 0 && (bs > 0 || s[sptr] == '#')) {
                bs += if (s[sptr] == '#') 1 else -1
                sptr--
            }

            bs = 0 // reset backspace count in case there are more backspaces than actual chars from previous loop
            while (tptr >= 0 && (bs > 0 || t[tptr] == '#')) {
                bs += if (t[tptr] == '#') 1 else -1
                tptr--
            }

            // when there is no backspace, compare if the chars of the pointers are the same
            // if they are the same, move the pointers to left by 1, break while loop if not (s[sptr] != t[tptr])
            // break while loop if there are no more chars to compare with (sptr < 0 or tptr < 0)
            if (sptr >= 0 && tptr >= 0 && s[sptr] == t[tptr]) {
                sptr--
                tptr--
            } else break
        }
        // the pointers should be at -1 if the remaining chars are the same
        // will be >-1 if the loop breaks before both pointers reach 0
        return sptr == -1 && tptr == -1
    } // TC: O(s.length + t.length), SC: O(1)
}
