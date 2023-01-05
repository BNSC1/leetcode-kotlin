class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val set = HashSet<String>() //set to store and check duplicates

        for (r in 0 until 9) {
            for (c in 0 until 9) {
                val box = board[r][c] //current box
                if (box == '.') {
                    continue //skip if the box is not filled
                }
                val block = Pair(r/3, c/3) //current coordinate in 3x3 block
                if (!set.add("$box in row $r") || //add the box to the row
                    !set.add("$box in col $c") || //add the box to the column
                    !set.add("$box in block $block")) { //add the box to current block
                    return false //if at least one of these operations return false, that means adding to set failed, duplicate is found, returning false.
                }
            }
        }
        return true
    }
}
