class Solution {
    public int orangesRotting(int[][] g) {
        int[] DIRS = {1, 0, -1, 0, 1};
        int rows = g.length;
        int cols = g[0].length;

        int res = 0;
        int fresh = 0;
        LinkedList<Pair<Integer,Integer>> q = new LinkedList<>();
        
        for (int r=0; r<rows; r++) {
            for (int c=0; c<cols; c++) {
                Pair<Integer,Integer> coord = new Pair<>(r, c);
                if (g[r][c] == 2) {
                    q.add(coord);
                } else if (g[r][c] == 1) fresh++;
            }
        }

        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                Pair<Integer,Integer> coord = q.poll();
                int r = coord.getKey();
                int c = coord.getValue();

                for (int d=0; d<DIRS.length-1; d++) {
                    int nr = r + DIRS[d];
                    int nc = c + DIRS[d + 1];
                    Pair<Integer,Integer> newCoord = new Pair<>(nr, nc);
                    if (nr >= 0 && nr < rows &&
                        nc >= 0 && nc < cols &&
                        g[nr][nc] == 1) {
                        q.add(newCoord);
                        g[nr][nc] = 2;
                        fresh--;
                    }
                }
            }
            res++;
        }

        if (fresh > 0) return -1;
        return res;
    }
}