class Solution {
    public int numIslands(char[][] g) {
        int rows = g.length;
        int cols = g[0].length;
        int[] DIRS = {1,0,-1,0,1};
        int res = 0;
        Set<Pair<Integer, Integer>> visit = new HashSet<>();
        class Helper {
            LinkedList<Pair<Integer, Integer>> q = new LinkedList<>();
            void markOff(Pair<Integer, Integer> coord) {
                q.add(coord);
                while (!q.isEmpty()) {
                    Pair<Integer, Integer> popCoord = q.poll();
                    int popR = popCoord.getKey();
                    int popC = popCoord.getValue();
                    for (int i=0; i<DIRS.length-1; i++) {
                        int newR = DIRS[i] + popR;
                        int newC = DIRS[i + 1] + popC;
                        Pair<Integer, Integer> newCoord = new Pair<>(newR, newC);
                        if (newR >= 0 && newR < rows &&
                            newC >= 0 && newC < cols &&
                            g[newR][newC] == '1' &&
                            !visit.contains(newCoord)) {
                                visit.add(newCoord);
                                q.add(newCoord);
                            }
                    }
                }
            }
        }
        Helper helper = new Helper();
        for (int r=0; r<rows; r++) {
            for (int c=0; c<cols; c++) {
                Pair<Integer, Integer> coord = new Pair<>(r, c);
                if (g[r][c] == '1' && !visit.contains(coord)) {
                    helper.markOff(coord);
                    res++;
                }
            }
        }
        return res;
    }
}