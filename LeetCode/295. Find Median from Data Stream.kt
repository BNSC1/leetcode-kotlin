class MedianFinder() {
    val smallHeap = PriorityQueue<Int>(compareByDescending{it}) //max heap with smaller nums
    val largeHeap = PriorityQueue<Int>() //min heap with larger nums

    fun addNum(num: Int) {
        smallHeap.offer(num)
        if (smallHeap.isNotEmpty() && largeHeap.isNotEmpty() &&
            smallHeap.peek() > largeHeap.peek()) {
            largeHeap.offer(smallHeap.poll())
        } //shift the added larger element in the small heap to the large heap

        if (smallHeap.size > largeHeap.size + 1) {
            largeHeap.offer(smallHeap.poll())
        } else if (largeHeap.size > smallHeap.size + 1) {
            smallHeap.offer(largeHeap.poll())
        } //if imbalanced, shift an element to either heap
    }

    fun findMedian(): Double {
        return if (smallHeap.size > largeHeap.size) {
            smallHeap.peek().toDouble()
        } else if (largeHeap.size > smallHeap.size) {
            largeHeap.peek().toDouble() //cases odd elements
        } else (smallHeap.peek() + largeHeap.peek().toDouble()) / 2
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * var obj = MedianFinder()
 * obj.addNum(num)
 * var param_2 = obj.findMedian()
 */