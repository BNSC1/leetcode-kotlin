class UndergroundSystem() {
    val travelTimes = HashMap<String, Pair<Int, Int>>().withDefault {0 to 0} //"startStation to endStation" : (count to sum time)
    val checkIns = HashMap<Int, Pair<String, Int>>() //id : (start station to start time)

    fun checkIn(id: Int, stationName: String, t: Int) {
        checkIns[id] = stationName to t
    }

    fun checkOut(id: Int, stationName: String, t: Int) {
        val startStation = checkIns.getValue(id).first
        val trip = "$startStation to $stationName"
        val elapsed = t - checkIns[id]!!.second
        val sumTime = travelTimes.getValue(trip).second
        val sumCount = travelTimes.getValue(trip).first

        travelTimes[trip] = (sumCount + 1) to (sumTime + elapsed)
        checkIns.remove(id)
    }

    fun getAverageTime(startStation: String, endStation: String): Double {
        return travelTimes.getValue("$startStation to $endStation").let {
            val count = it.first
            val time = it.second
            if (count != 0) time / count.toDouble()
            else 0.0
        }
    }

}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * var obj = UndergroundSystem()
 * obj.checkIn(id,stationName,t)
 * obj.checkOut(id,stationName,t)
 * var param_3 = obj.getAverageTime(startStation,endStation)
 */