import java.io.*;
import java.util.*;
import javafx.util.*;

class Solution {
    static int shortestCellPath(int[][] grid, int sr, int sc, int tr, int tc) {
        HashSet<Pair<Integer, Integer>> visited = new HashSet<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int[] res = {-1};
        class Inner {
            void dfs(int r, int c) {
                Pair<Integer, Integer> coord = new Pair<>(r, c);
                if (r < 0 || c < 0 ||
                    r >= rows || c >= cols ||
                    grid[r][c] == 0 || visited.contains(coord)) return;
                if (r == tr && c == tc) {
                    res[0] = Math.max(res[0], visited.size());
                    return;
                }
                visited.add(coord);

                for (Dir d : Dir.values()) {
                    dfs(r + d.r, c + d.c);
                }
                visited.remove(coord);
            }
        }
        new Inner().dfs(sr, sc);

        return res[0];
    }

    public static void main(String[] args) {
    }
}

enum Dir {
    UP(0, -1), DOWN(0, 1), LEFT(-1, 0), RIGHT(1, 0);
    int r;
    int c;

    Dir(int r, int c) {
        this.r = r;
        this.c = c;
    }
}