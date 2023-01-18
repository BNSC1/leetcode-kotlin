class Solution {
    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val wordCount = words.toList().groupingBy { it }.eachCount() //convert to list to use grouping to convert to map with word : count
        val heap = PriorityQueue(Comp()) //custom comparator required because we are comparing both the occurance count and the word
            .apply {
                wordCount.forEach { //add map entries to the heap
                    offer(it)
                }
            }
        val res = mutableListOf<String>()
        repeat(k) { //add first k elements in the heap
            res.add(heap.poll()!!.key)
        }
        return res
    }
}
class Comp: Comparator<Map.Entry<String, Int>> {
    override fun compare(p0: Map.Entry<String, Int>, p1: Map.Entry<String, Int>): Int {
        return when {
            p0.value > p1.value -> -1
            p0.value < p1.value -> 1 //sort the occurance count in descending order first
            else -> { //if they have equal count, sort their word in ascending order
                p0.key.compareTo(p1.key)
            }
        }
    }
}
