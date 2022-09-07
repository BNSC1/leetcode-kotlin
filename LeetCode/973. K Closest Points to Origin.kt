class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val dst = mutableListOf<IntArray>() //to store the coordinate with calculated distance
        
        points.forEach { //calculate distance for each coordinate
            val d = it[0]*it[0] + it[1]*it[1]
            dst.add(intArrayOf(d, it[0], it[1]))
        }

        return dst.run {
            sortBy {it[0]}//then sort the list by distance
            val res = mutableListOf<IntArray>() //result with x:y
            take(k).forEach { //take the first k elements
                res.add(intArrayOf(it[1], it[2])) //add x:y to the res list
            }
            res.toTypedArray() //return the array of x:y
        }
    }
}
