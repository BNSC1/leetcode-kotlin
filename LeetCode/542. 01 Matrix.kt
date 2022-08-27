class Solution {
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val row = mat.size
        val col = mat[0].size
        
        for (r in 0..row-1) {
            for (c in 0..col-1) { //calculate elements from top-left to bottom-right
                if (mat[r][c] == 0) continue //skip 0
                mat[r][c] = row-1 + col-1 //assume the largest possible value first
                if (r > 0) mat[r][c] = Math.min(mat[r-1][c]+1, mat[r][c]) //if the top element is smaller, take the value+1
                if (c > 0) mat[r][c] = Math.min(mat[r][c-1]+1, mat[r][c]) //if the left element is smaller, take the value+1
            }
        }
        for (r in row-1 downTo 0) {
            for (c in col-1 downTo 0) { //calculate elements from bottom-right to top-left
                if (mat[r][c] == 0) continue
                if (r < row-1) mat[r][c] = Math.min(mat[r+1][c]+1, mat[r][c]) //if the bottom element is smaller, take the value+1
                if (c < col-1) mat[r][c] = Math.min(mat[r][c+1]+1, mat[r][c]) //if the right element is smaller, take the value+1
            }
        }
        return mat
    }
}