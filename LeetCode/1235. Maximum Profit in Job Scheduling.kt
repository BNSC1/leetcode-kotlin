class Solution {
    fun jobScheduling(startTimes: IntArray, endTimes: IntArray, profits: IntArray): Int {
        val jobs = Array(startTimes.size) {Job(0,0,0)}.also { jobs ->
            for (i in 0 until startTimes.size) {
                jobs[i] = Job(startTimes[i], endTimes[i], profits[i])
            }
            jobs.sortBy { it.endTime }
        }
        val dp = TreeMap<Int,Int>().also { it[0] = 0 } //end time: profit

        jobs.forEach { job ->
            val sum = job.profit + dp.floorEntry(job.startTime).value //most recent job profit sum + current job profit
            dp[job.endTime] = sum.coerceAtLeast(dp.lastEntry().value)
        }
        return dp.lastEntry().value //latest end time in dp
    }
}
class Job(val startTime: Int, val endTime: Int, val profit: Int)