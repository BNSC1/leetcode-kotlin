class Solution {
    public int[][] updateMatrix(int[][] m) {
        int rows = m.length;
        int cols = m[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (m[r][c] != 0) {
                    m[r][c] = rows + cols - 2;
                    if (r > 0) m[r][c] = Math.min(m[r][c], m[r-1][c] + 1);
                    if (c > 0) m[r][c] = Math.min(m[r][c], m[r][c-1] + 1);
                } else continue;
            }
        }
        for (int r = rows - 1; r >= 0; r--) {
            for (int c = cols - 1; c >= 0; c--) {
                if (m[r][c] != 0) {
                    if (r < rows - 1) m[r][c] = Math.min(m[r][c], m[r+1][c] + 1);
                    if (c < cols - 1) m[r][c] = Math.min(m[r][c], m[r][c+1] + 1);
                } else continue;
            }
        }
        return m;
    }
}