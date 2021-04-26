package question1072_flip_columns_for_maximum_number_of_equal_rows;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int maxEqualRowsAfterFlips(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    Map<String, Integer> map = new HashMap<>();
    int result = 0;
    for (int[] row : matrix) {
      StringBuilder sb = new StringBuilder();
      for (int num : row) {
        sb.append(row[0] == 0 ? num : (num ^ 1));
      }
      String s = sb.toString();
      map.put(s, map.getOrDefault(s, 0) + 1);
      result = Math.max(map.get(s), result);
    }
    return result;
  }

}