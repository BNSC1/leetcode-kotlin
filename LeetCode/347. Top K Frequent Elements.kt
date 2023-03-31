class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = HashMap<Int, Int>() //num: appearance
        val heap = PriorityQueue<Pair<Int,Int>>(compareByDescending { it.second }) //max heap with comparator by appearance count
        val res = IntArray(k)

        nums.forEach { //count to map
            map[it] = (map[it] ?: 0) + 1
        }

        map.forEach { n, cnt -> //offer to max heap
            heap.offer(n to cnt)
        }

        for(i in 0 until k){ //add k elements
            res[i] = heap.poll().first
        }

        return res
    }
}