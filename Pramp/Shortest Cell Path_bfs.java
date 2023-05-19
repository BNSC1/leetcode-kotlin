import java.io.*;
import java.util.*;
import javafx.util.*;

class Solution {
    static int shortestCellPath(int[][] grid, int sr, int sc, int tr, int tc) {
        HashSet<Pair<Integer, Integer>> visited = new HashSet<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int level = 0;
        LinkedList<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(sr, sc));
      
        while (!q.isEmpty()) {
          Pair<Integer, Integer> coord = q.poll();
          int r = coord.getKey();
          int c = coord.getValue();
          if (r == tr && c == tc) return level;
          for (Dir d : Dir.values()) {
            int nextR = r + d.r;
            int nextC = c + d.c;
            Pair<Integer, Integer> newCoord = new Pair<>(nextR, nextC);
            if (nextR >= 0 && nextC >= 0 &&
                nextR < rows && nextC < cols &&
                !visited.contains(newCoord) && grid[nextR][nextC] == 1) {
                  visited.add(coord);
                  q.add(newCoord);
            }
          }
          level++;
        }
        return -1;
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