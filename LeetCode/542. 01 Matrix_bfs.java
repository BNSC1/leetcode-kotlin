class Solution {
    int[] DIR = new int[]{0, 1, 0, -1, 0};
    public int[][] updateMatrix(int[][] m) {
        int rows = m.length;
        int cols = m[0].length;

        LinkedList<int[]> q = new LinkedList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (m[r][c] == 0) q.push(new int[] {r, c});
                else m[r][c] = -1;
            }
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            for (int i = 0; i<4; i++) {
                int nr = r + DIR[i], nc = c + DIR[i + 1];
                if (nr < 0 || nr == rows ||
                    nc < 0 || nc == cols ||
                    m[nr][nc] != -1) continue;
                m[nr][nc] = m[r][c] + 1;
                q.add(new int[]{nr, nc});
            }
        }
        return m;
    }
} //TC: O(m*n), SC: O(m*n)