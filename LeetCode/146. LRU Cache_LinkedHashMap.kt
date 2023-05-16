class LRUCache(capacity: Int) {
    val map = object : LinkedHashMap<Int, Int>(capacity) {
        override fun removeEldestEntry(entry: MutableMap.MutableEntry<Int, Int>?) = size > capacity
    }

    fun get(key: Int): Int {
        if (key !in map) return -1
        val value = map[key]!!
        map.remove(key)
        map[key] = value
        return map[key]!!
    }

    fun put(key: Int, value: Int) {
        if (key in map) map.remove(key)
        map[key] = value
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */