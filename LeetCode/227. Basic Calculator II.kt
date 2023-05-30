class Solution {
    fun calculate(s: String): Int {
        val s = StringBuilder("+").apply {
            append(s.replace(" ", ""))
        }.toString() //trim spaces

        val nums = LinkedList<Int>()
        var opIndex = 0
        while (opIndex < s.length) {
            if (s[opIndex] == '+' || s[opIndex] == '-') {
                var nextDigit = opIndex + 1
                while (nextDigit < s.length && s[nextDigit].isDigit()) {
                    nextDigit++
                }
                val num = Integer.parseInt(s.substring(opIndex+1, nextDigit))
                nums.push(if (s[opIndex] == '+') num else -num)
                opIndex = nextDigit
            } else if (s[opIndex] == '*' || s[opIndex] == '/') {
                var nextDigit = opIndex + 1
                while (nextDigit < s.length && s[nextDigit].isDigit()) {
                    nextDigit++
                }
                val num = Integer.parseInt(s.substring(opIndex+1, nextDigit))
                val lastNum = nums.pop()
                nums.push(if (s[opIndex] == '*') lastNum * num else lastNum / num)
                opIndex = nextDigit
            } else opIndex++
        }
        var res = 0
        while (nums.isNotEmpty()) {
            res += nums.pop()
        }
        return res
    }
}