class TimeMap() {
    val map = HashMap<String, MutableList<Data>>() //key : list(value, time)

    fun set(key: String, value: String, time: Int) {
        if (key !in map) {
            map[key] = mutableListOf()
        } //add a new empty list for the key if it doesn't exist in map
        map[key] = map[key]!!.apply{ add(Data(value, time)) } //add the data set to the list
    }

    fun get(key: String, time: Int): String {
        val values = map.getOrDefault(key, mutableListOf()) //get list for the key from map, if not found, default to an empty list
        var res = ""

        var start = 0
        var end = values.size - 1 //binary search because later added data set will only have incremented timestamp

        while(start <= end) {
            val mid = (start + end) / 2
            if (values[mid].time <= time) { //set to result if data timestamp is less than or equal to target timestamp
                res = values[mid].value //will be overridden if there is a more recent value
                start = mid + 1
            } else { //only move end pointer if timestamp of this data set is more recent than target timestamp
                end = mid - 1
            }
        }
        return res
    }

}

class Data(val value: String, val time: Int)

/**
 * Your TimeMap object will be instantiated and called as such:
 * var obj = TimeMap()
 * obj.set(key,value,timestamp)
 * var param_2 = obj.get(key,timestamp)
 */
