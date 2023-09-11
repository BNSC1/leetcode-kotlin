class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var min = 1
        var max = piles.max()
        var res = Int.MAX_VALUE
        
        fun canFinish(eatNum: Int): Boolean {
            var timeLeft = h
            piles.forEach { pile ->
                timeLeft -= pile / eatNum
                if (pile % eatNum != 0) timeLeft-- //Koko still spends a full hour eating leftover bananas
            }
            return timeLeft >= 0
        }

        while (min <= max) {
            val mid = (max + min) / 2
            if (canFinish(mid)) { //if such eating rate is able to finish all piles in time, search for the left side
                res = minOf(res, mid)
                max = mid - 1
            } else { //if not, search for the right side
                min = mid + 1
            }
        }
        return res
    }
}