package question1074_number_of_submatrices_that_sum_to_target;

import java.util.HashMap;
import java.util.Map;

/**
 * 参考 LeetCode0560。
 *
 * 时间复杂度是 O(m * n * min(m, n))。空间复杂度是 O(m * n)。
 *
 * 执行用时：1377ms，击败41.10%。消耗内存：47MB，击败47.06%。
 */
public class Solution2 {
  public int numSubmatrixSumTarget(int[][] matrix, int target) {
    int m = matrix.length, n = matrix[0].length, result = 0;
    if (n >= m) {
      int[][] sumCol = new int[m][n];
      for (int j = 0; j < n; j++) {
        for (int i = 0; i < m; i++) {
          sumCol[i][j] = matrix[i][j];
          if (i > 0) {
            sumCol[i][j] += sumCol[i - 1][j];
          }
        }
      }
      for (int x1 = 0; x1 < m; x1++) {
        for (int x2 = x1; x2 < m; x2++) {
          int sum = 0;
          Map<Integer, Integer> map = new HashMap<>();
          map.put(0, 1);
          for (int j = 0; j < n; j++) {
            sum += sumCol[x2][j];
            if (x1 > 0) {
              sum -= sumCol[x1 - 1][j];
            }
            if (map.containsKey(sum - target)) {
              result += map.get(sum - target);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
          }
        }
      }
    } else {
      int[][] sumRow = new int[m][n];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          sumRow[i][j] = matrix[i][j];
          if (j > 0) {
            sumRow[i][j] += sumRow[i][j - 1];
          }
        }
      }
      for (int y1 = 0; y1 < n; y1++) {
        for (int y2 = y1; y2 < n; y2++) {
          int sum = 0;
          Map<Integer, Integer> map = new HashMap<>();
          map.put(0, 1);
          for (int i = 0; i < m; i++) {
            sum += sumRow[i][y2];
            if (y1 > 0) {
              sum -= sumRow[i][y1 - 1];
            }
            if (map.containsKey(sum - target)) {
              result += map.get(sum - target);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
          }
        }
      }
    }
    return result;
  }
}
