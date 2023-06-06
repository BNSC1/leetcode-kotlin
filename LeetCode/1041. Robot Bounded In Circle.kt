class Solution {
    fun isRobotBounded(insts: String): Boolean {
        var r = 0
        var c = 0
        var dir = Dirs.values()[0]
        insts.forEach { i ->
            when (i) {
                'G' -> {
                    r += dir.r
                    c += dir.c
                }
                'L' -> {
                    val ord = (dir.ordinal + Dirs.values().size - 1) % Dirs.values().size
                    dir = Dirs.values()[ord]
                }
                'R' -> {
                    val ord = (dir.ordinal + 1) % Dirs.values().size
                    dir = Dirs.values()[ord]
                }
            }
        }
        return r == 0 && c == 0 || dir != Dirs.NORTH
    }
}
enum class Dirs(val r: Int = 0, val c: Int = 0) {
    NORTH(r = -1),
    EAST(c = 1),
    SOUTH(r = 1),
    WEST(c = -1)
}