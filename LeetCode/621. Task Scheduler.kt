class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val charCount = tasks.toList().groupingBy { it }.eachCount() //convert to list to use grouping to convert to map with char : count
        var t = 0 //timer
        val heap = PriorityQueue<Int>(compareByDescending { it }).apply { //compareByDescending to turn from min heap to max heap, as we want the task with the most count to be executed first
            charCount.values.forEach {
                offer(it) //add each value in charCount, chars do not matter here
            }
        }
        val q: Queue<Pair<Int, Int>> = LinkedList() //pair of count : time to execute

        while (heap.isNotEmpty() || q.isNotEmpty()) {
            t++ //time elapsed
            if (heap.isNotEmpty()) {
                val cnt = heap.poll()!! - 1 //pull from heap and subtract count of the char
                if (cnt != 0) {
                    q.add(Pair(cnt, t + n))
                } //add to queue with delay added to time if the task still has count
            }
            if (q.isNotEmpty() && q.peek().second == t) { //if the queue head has time matches current timer
                heap.offer(q.poll().first) //add back to heap
            }
        }
        return t
    }
}
