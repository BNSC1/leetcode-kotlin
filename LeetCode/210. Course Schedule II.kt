class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val res = mutableListOf<Int>()
        val cycle = HashSet<Int>() //detect if there is cycle
        val visited = HashSet<Int>() //store visited courses
        val prereqs = HashMap<Int, MutableList<Int>>() //course: prerequisite courses
        repeat(numCourses) { course ->
            prereqs[course] = mutableListOf() //init each course with an empty list
        }
        prerequisites.forEach {
            prereqs[it[0]]!!.add(it[1]) //add prerequisites to each course
        }

        fun dfs(course: Int): Boolean {
            if (course in cycle) {
                return false //cycle detected
            }
            if (course in visited) {
                return true //skip visited
            }
            cycle.add(course)
            prereqs[course]!!.forEach { pre -> //return false if cycle detected in its prerequisites
                if (!dfs(pre)) {
                    return false
                }
            }
            cycle.remove(course) //remove from the cycle set if no cycle detected
            visited.add(course) //add to visited
            res.add(course) //then add to the result
            return true
        }
        repeat(numCourses) { c ->
            if (!dfs(c)) {
                return intArrayOf() //return an empty array if a cycle is detected
            }
        }
        return res.toIntArray() //if no cycle, return the result
    }
}
