class Solution {
    fun insert(i: Array<IntArray>, nI: IntArray): Array<IntArray> {
        val res = mutableListOf<IntArray>()
        
        i.forEachIndexed { index, it ->
            if (nI[1]<it[0]) { //if the new interval is before the current element, and has no overlap
                res.add(nI) //add the new interval to the solution first
                res.addAll(i.copyOfRange(index, i.size)) //then add the rest of the array to the solution
                return res.toTypedArray() //return IntArray because no more calculation is required
            }
            else if (nI[0]>it[1]) res.add(it) //if the new interval is after the current element, and has no overlap, add it without further actions
            else { //if overlapped, get the smaller start number, and the largest end number
                nI[0] = Math.min(it[0],nI[0])
                nI[1] = Math.max(it[1],nI[1])
            }
        }
        res.add(nI) //add to the solution if the new interval is the last element
        
        return res.toTypedArray() //convert to IntArray from MutableList
    }
}