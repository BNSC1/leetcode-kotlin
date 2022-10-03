class Solution {
    fun climbStairs(n: Int): Int {
        //by calculating ways to n backwards
        var prev = 1 //ways from the previous one stair to the last stair is always 1
        var next = 1 //ways to the last stair is always 1

        for (i in 0 until n-1) { //loop each stair for ways to there
            val tmp = prev
            prev = prev+next //adding up sets of ways to next 2 stairs
            next = tmp //next is now the old prev
        }

        return prev
    }
}
