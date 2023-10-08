class Solution {
    fun minProcessingTime(pTimes: List<Int>, tasks: List<Int>): Int {
        var res = 0
        val pTimes = pTimes.sorted()
        val tasks = tasks.sortedDescending()
        
        var i = 0
        pTimes.forEach { pTime ->
            var total = 0
            repeat(4) {
                total = max(total, pTime + tasks[i])
                i++
            }
            res = max(res, total)
        }
        return res
    }
}