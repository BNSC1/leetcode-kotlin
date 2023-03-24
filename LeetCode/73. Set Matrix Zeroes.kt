class Solution {
    fun setZeroes(m: Array<IntArray>): Unit {
        val rows = m.size
        val cols = m[0].size
        var firstRow = -1 //additional variable for the first row

        //iterate through the whole matrix to decide which rows/cols need to be 0
        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (m[r][c] == 0) { //if a 0 is found
                    m[0][c] = 0 //mark its topmost to 0

                    if (r == 0) { //and if it is the first row
                        firstRow = 0 //set the firstRow variable to 0
                    } else {
                        m[r][0] = 0 //mark its leftmost to 0
                    }
                }
            }
        }

        for (r in 1 until rows) { //mark other elements to 0, skipping the first row and first col so there is a reference for which row/col to be 0
            for (c in 1 until cols) {
                if (m[0][c] == 0 || m[r][0] == 0) { //if it's leftmost/topmost is 0
                    m[r][c] = 0
                }
            }
        }

        //handle the first row/col
        if (m[0][0] == 0) { //if the first column has been marked to be 0
            for (r in 0 until rows) {
                m[r][0] = 0
            }
        }

        //run first row last so it does not overwrite reference for the first column
        if (firstRow == 0) { //if firstRow has been marked to be 0
            for (c in 0 until cols) {
                m[0][c] = 0
            }
        }
    }
}