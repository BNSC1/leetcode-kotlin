class Solution {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false

        var x = x.toLong()
        var div: Long = 1
        while (x >= div * 10) { //div * 10 in Int will cause overflow
            div *= 10 //shift div digit to the leftmost of x
        }
        while (x > 0) {
            val right = x % 10
            val left = x / div

            if (left != right) return false

            x = (x % div) / 10 //take both sides of digit off
            div = div / 100 //since we took 2 digits off, shifting the divider
        }
        return true
    }
}