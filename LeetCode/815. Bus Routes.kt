class Solution {
    fun numBusesToDestination(routes: Array<IntArray>, source: Int, target: Int): Int {
        if (source == target) return 0

        val stops = HashMap<Int, MutableList<Int>>().withDefault { mutableListOf() }.also {  //stop : buses that lead to this stop
            routes.forEachIndexed { busI, bus ->
                bus.forEach { stop ->
                    it[stop] = it.getValue(stop).apply { add(busI) }
                }
            }
        }
        val visitedStop = HashSet<Int>()
        val visitedBus = HashSet<Int>()
        val queue = LinkedList<Int>().apply { add(source) }
        var travels = -1

        while (queue.isNotEmpty()) {
            travels++
            val currStopCnt = queue.size
            repeat(currStopCnt) {
                val currStop = queue.poll()
                stops[currStop]!!.forEach { bus ->
                    if (bus in visitedBus) return@forEach
                    visitedBus.add(bus)

                    routes[bus].forEach { stop ->
                        if (stop in visitedStop) return@forEach
                        if (stop == target) return ++travels

                        queue.add(stop)
                        visitedStop.add(stop)
                    }
                }
            }
        }
        return -1
    }
}