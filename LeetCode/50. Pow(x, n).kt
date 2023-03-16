class Solution {
    fun myPow(x: Double, n: Int): Double {
        fun calc(x: Double, n: Int): Double {
            if (x == 0.0) return 0.0
            if (n == 0) return 1.0
            
            var res = calc(x, n / 2) //divide further
            res = res * res //then combine the result
            if (n % 2 != 0) { //odd power problem is multiplied by x again
                res = res * x
            }
            return res
        }

        val res = calc(x, n)
        return if (n >= 0) res //negative power handling
               else 1 / res
    }
}