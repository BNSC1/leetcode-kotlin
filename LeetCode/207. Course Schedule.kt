class Solution {
    val preMap = HashMap<Int, MutableList<Int>>() //course:prereq list
    val visitSet = HashSet<Int>() //dfs visited courses

    fun canFinish(numCourses: Int, prereqs: Array<IntArray>): Boolean {
        prereqs.forEach { //map prerequisites
            if (it[0] in preMap) { //add new prerequisites if the course is already in the map
                preMap[it[0]] = preMap[it[0]]!!.apply{add(it[1])}
            } else { //add new prerequisite list if it isn't
                preMap[it[0]] = mutableListOf(it[1])
            }
        }
        for (c in 0 until numCourses) { //loop all courses
            if (!dfs(c)) return false
        }
        return true
    }

    fun dfs(course: Int): Boolean {
        if (course in visitSet) return false //if the course is already visited, that means there is a loop, so returning false
        if (preMap.isEmpty()) return true //if there is no prerequisite, return true

        visitSet.add(course) //add the course to visit set
        if (course in preMap) {
            for(p in preMap[course]!!) { //loop prerequisites of the course
                if (!dfs(p)) return false //return false if there is a loop
            }
        }
        visitSet.remove(course) //remove the course if no loop is found
        preMap[course] = mutableListOf<Int>() //reset the prerequisite map for the course
        return true
    }
}
