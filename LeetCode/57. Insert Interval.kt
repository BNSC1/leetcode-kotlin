class Solution {
    fun insert(Is: Array<IntArray>, nI: IntArray): Array<IntArray> {
        val res = mutableListOf<IntArray>()

        Is.forEachIndexed { i, it ->
            if (it[0] > nI[1]) { //when current interval is greater than the new interval, no more overlap is possible
                res.add(nI)
                res.addAll(Is.copyOfRange(i, Is.size))
                return res.toTypedArray() //add new interval and the rest of intervals then return
            }

            if (it[1] < nI[0]) { //when overlapping has not occurred yet
                res.add(it) //add current interval
            } else { //when current interval is overlapping
                nI[0] = Math.min(it[0], nI[0])
                nI[1] = Math.max(it[1], nI[1]) //set the new interval with the lesser start and the greater end
            }
        }
        //if the new interval is the end of the array
        res.add(nI)
        return res.toTypedArray() //add it and return
    }
}
