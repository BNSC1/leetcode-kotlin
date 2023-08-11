class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length;
        int cols = image[0].length;
        int ogColor = image[sr][sc];
        LinkedList<Pair<Integer, Integer>> q = new LinkedList<>();
        HashSet<Pair<Integer, Integer>> visit = new HashSet<>();
        
        Pair<Integer, Integer> srcCoord = new Pair<>(sr, sc);
        q.add(srcCoord);
        visit.add(srcCoord);
        while (!q.isEmpty()) {
            Pair<Integer, Integer> coord = q.pollFirst();
            image[coord.getKey()][coord.getValue()] = color;
            for (Dir d : Dir.values()) {
                Pair<Integer, Integer> newCoord = new Pair<>(coord.getKey() + d.r, coord.getValue() + d.c);
                if (newCoord.getKey() >= rows || newCoord.getKey() < 0 ||
                    newCoord.getValue() >= cols || newCoord.getValue() < 0 ||
                    visit.contains(newCoord) || image[newCoord.getKey()][newCoord.getValue()] != ogColor) continue;
                    visit.add(newCoord);
                    q.add(newCoord);
                    
            }
        }
        return image;
    }
} //TC: O(m*n), SC: O(m*n)
enum Dir {
    UP(0,-1),DOWN(0,1),LEFT(-1,0),RIGHT(1,0);
    int r;int c;
    Dir(int r, int c) {
        this.r = r;
        this.c = c;
    }
}