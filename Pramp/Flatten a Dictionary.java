import java.io.*;
import java.util.*;

class Solution {

  static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
      HashMap<String, String> res = new HashMap<>();
      class Helper {
          void dfs(String prefix, Object o) {
              if (o instanceof Map) {
                  for (Map.Entry<String, Object> e : ((Map<String, Object>) o).entrySet()) {
                    String newPrefix = prefix;
                    if (e.getKey() != "" && prefix != "") {
                      newPrefix += ".";
                    }
                    dfs(newPrefix + e.getKey(), e.getValue());
                  }
              } else {
                  res.put(prefix, (String)o);
              }
          }
      }
      Helper h = new Helper();
      for (Map.Entry<String, Object> e : dict.entrySet()) {
          h.dfs(e.getKey(), e.getValue());
      }

      return res;
  }

    public static void main(String[] args) {

    }

}