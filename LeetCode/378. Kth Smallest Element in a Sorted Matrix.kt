class Solution {
    fun kthSmallest(m: Array<IntArray>, kth: Int): Int {
        val size = m.size
        val pq = PriorityQueue<Pair<Int, Int>>( compareBy { m[it.first][it.second] } ) //coordinates in min heap

        repeat(size) { row -> //add first element of each row
            pq.offer(row to 0)
        }
        
        var nth = 0    
        while (true) {
            nth++
            val poll = pq.poll()
            if (nth == kth) return m[poll.first][poll.second]
            if (poll.second + 1 < size) { //offer the next element of the row if avails
                pq.offer(poll.first to poll.second+1)
            }
        }
    }
}