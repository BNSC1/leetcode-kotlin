class FrequencyTracker() {
    val freqNums = HashMap<Int, MutableSet<Int>>().withDefault { mutableSetOf() } //freq : nums that have this freq
    val numFreqs = HashMap<Int, Int>().withDefault { 0 } //num : freq it is in

    fun add(n: Int) {
        if (numFreqs.getValue(n) > 0) {
            freqNums[numFreqs[n]!!]!!.remove(n)
        }
        numFreqs[n] = numFreqs.getValue(n) + 1
        freqNums[numFreqs[n]!!] = freqNums.getValue(numFreqs[n]!!).apply {add(n)}
    }

    fun deleteOne(n: Int) {
        if (numFreqs.getValue(n) == 0) return
        freqNums[numFreqs[n]!!]!!.remove(n)
        numFreqs[n] = numFreqs.getValue(n) - 1
        freqNums[numFreqs[n]!!] = freqNums.getValue(numFreqs[n]!!).apply {add(n)}
    }

    fun hasFrequency(freq: Int): Boolean {
        return freqNums.getValue(freq).isNotEmpty()
    }

}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * var obj = FrequencyTracker()
 * obj.add(number)
 * obj.deleteOne(number)
 * var param_3 = obj.hasFrequency(frequency)
 */