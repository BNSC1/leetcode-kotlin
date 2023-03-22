class Solution {
    fun reverse(x: Int): Int {
        var x = x
        var res = 0

        while (x != 0) {
            val newDigit = x % 10
            x = x / 10 //take 1 digit from x

            //if we can predict overflow from current result, stop the loop and return 0
            if (res > Int.MAX_VALUE / 10 || // res > 214748364
                res == Int.MAX_VALUE / 10 && newDigit > Int.MAX_VALUE % 10 // res == 214748364 && newDigit > 7
            ) return 0
            if (res < Int.MIN_VALUE / 10 || // res < -214748364
                res == Int.MIN_VALUE / 10 && newDigit < Int.MIN_VALUE % 10 // res == -214748364 && newDigit < -8
            ) return 0

            //if not, add the digit to the result
            res = res * 10
            res += newDigit
        }
        return res
    }
}