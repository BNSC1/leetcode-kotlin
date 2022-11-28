class Solution {
    fun myAtoi(s: String): Int {
        val str = s.trim() //trim white space off the string
        if(str.isEmpty()) return 0 //return 0 if the string is already empty

        var res: Long = 0 //result in long for case with number exceeding integer limit
        var i = 0 //starting iteration
        val sign = when {
                    str[0] == '-' -> {
                        i = 1
                        -1
                    }
                    str[0] == '+' -> {
                        i = 1
                        1
                    }
                    else -> 1
                   } //iteration starts at 1 if the string starts with '+' or '-',
                     //also assign negative sign if it starts with '-', positive sign for everything else

        for (c in str.slice(i until str.length)) { //loop from starting iteration
            if (c in '0'..'9') {
                res = res * 10 + Character.getNumericValue(c)
                //multiply old result by 10 then add new digit to the result
                //using getNumericValue because digitToInt is unavailable in LeetCode
            } else break //break the loop for non-numeric char

            if (res * sign > Int.MAX_VALUE) return Int.MAX_VALUE
            if (res * sign < Int.MIN_VALUE) return Int.MIN_VALUE //return when result exceeds integer limit
        }
        return res.toInt() * sign
    }
}
