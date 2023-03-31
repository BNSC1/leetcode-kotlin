class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = HashMap<Int, Int>() //num: appearance
        val heap = PriorityQueue<Map.Entry<Int,Int>>(compareByDescending { it.value }) //max heap with comparator by appearance count
        val res = IntArray(k)

        nums.forEach { //count to map
            map[it] = (map[it] ?: 0) + 1
        }

        map.forEach { //offer map to max heap
            heap.offer(it)
        }

        for(i in 0 until k){ //poll k times to the result
            res[i] = heap.poll().key
        }

        return res
    }
}