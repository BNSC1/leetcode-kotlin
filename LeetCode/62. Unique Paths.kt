class Solution {
    fun uniquePaths(c: Int, r: Int): Int {
        var row = Array<Int>(r) {1} //init with a bottommost row to be the base cases with only 1 way to finish

        for(i in 0 until c-1) { //loop every row except the bottommost one, from bottom to top
            val newRow = Array<Int>(r) {1} //a new row
            for (j in r-2 downTo 0) { //ignore the last column because those coordinates only have 1 way to finish
                newRow[j] = newRow[j+1] + row[j] //sum ways of right coordinate and bottom coordinate to finish
                /*
                S - - - 1

                - - - - 1

                - - - - 1

                - - - 2<1
                      ^
                1 1 1 1 1
                */
            }
            row = newRow //assign the new row to be the old row
        }
        return row[0]
    }
}
