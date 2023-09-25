import java.io.*;
import java.util.*;

class Solution {

  static int[][] findPairsWithGivenDifference(int[] arr, int k) {
    HashSet<Integer> set = new HashSet<>();
    ArrayList<int[]> res = new ArrayList<>();
    
    for (int i = 0; i < arr.length; i++) {
      set.add(arr[i]);
    }
    for (int i = 0; i < arr.length; i++) {
      int y = arr[i];
      int x = k + y;
      if (set.contains(x)) {
        res.add(new int[] {x, y});
      }
      //x - y = k
      //x = k + y
    }
    return res.toArray(new int[0][0]);
  }

  public static void main(String[] args) {}

}