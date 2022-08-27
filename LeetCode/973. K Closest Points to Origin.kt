class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val res = mutableListOf<IntArray>()
        val dst = mutableListOf<IntArray>() //to store the coordinate with calculated distance
        
        points.forEach { //calculate distance for each coordinate
            val d = (Math.pow(it[0].toDouble(), 2.0) + Math.pow(it[1].toDouble(), 2.0)).toInt()
            dst.add(intArrayOf(d, it[0], it[1]))
        }
        dst.sortBy { it[0] }  //sort by the distance
        dst.take(k).forEach { //take the first k elements then add the coordinate to the result
            res.add(intArrayOf(it[1],it[2]))
        }
        return res.toTypedArray()
    }
}