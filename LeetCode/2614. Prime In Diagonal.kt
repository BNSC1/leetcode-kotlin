class Solution {
    fun diagonalPrime(nums: Array<IntArray>): Int {
        var res = 0
        fun isPrime(n: Int) : Boolean {
            if (n <= 1) return false
            if (n == 2) return true
            var i = 2
            while (i <= Math.sqrt(n.toDouble())) {
                if (n % i++ == 0) return false
            }
            return true
        }
        for (r in 0 until nums.size) {
            val c = r
            if (isPrime(nums[r][c])) res = Math.max(res, nums[r][c])
        }
        
        for (r in nums.size - 1 downTo 0) {
            val c = nums.size - r - 1
            if (isPrime(nums[r][c])) res = Math.max(res, nums[r][c])
        }
        return res
    }
}