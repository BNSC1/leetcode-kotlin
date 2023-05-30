class Solution {
    fun simplifyPath(path: String): String {
        val dirs = LinkedList<String>()
        val curr = StringBuilder()

        (path + "/").forEach { c ->
            if (c == '/') {
                if (curr.toString() == "..") {
                    if (dirs.isNotEmpty()) dirs.pollLast()
                } else if (curr.isNotEmpty() && curr.toString() != ".") {
                    dirs.add(curr.toString())
                }
                curr.clear()
            } else curr.append(c)
        }

        return "/" + dirs.joinToString("/")
    }
}