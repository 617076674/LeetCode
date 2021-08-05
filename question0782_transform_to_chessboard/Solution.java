package question0782_transform_to_chessboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  public int movesToChessboard(int[][] board) {
    int n = board.length;

    // count[code] = v, where code is an integer
    // that represents the row in binary, and v
    // is the number of occurrences of that row
    Map<Integer, Integer> count = new HashMap<>();
    for (int[] row : board) {
      int code = 0;
      for (int x : row) {
        code = 2 * code + x;
      }
      count.put(code, count.getOrDefault(code, 0) + 1);
    }

    int k1 = analyzeCount(count, n);
    if (k1 == -1) {
      return -1;
    }

    // count[code], as before except with columns
    count = new HashMap<>();
    for (int c = 0; c < n; ++c) {
      int code = 0;
      for (int r = 0; r < n; ++r) {
        code = 2 * code + board[r][c];
      }
      count.put(code, count.getOrDefault(code, 0) + 1);
    }

    int k2 = analyzeCount(count, n);
    return k2 >= 0 ? k1 + k2 : -1;
  }

  public int analyzeCount(Map<Integer, Integer> count, int n) {
    // Return -1 if count is invalid
    // Otherwise, return number of swaps required
    if (count.size() != 2) {
      return -1;
    }
    List<Integer> keys = new ArrayList<>(count.keySet());
    int k1 = keys.get(0), k2 = keys.get(1);
    // If lines aren't in the right quantity
    if (!(count.get(k1) == n / 2 && count.get(k2) == (n + 1) / 2) &&
        !(count.get(k2) == n / 2 && count.get(k1) == (n + 1) / 2)) {
      return -1;
    }
    // If lines aren't opposite
    if ((k1 ^ k2) != (1 << n) - 1) {
      return -1;
    }
    int Nones = (1 << n) - 1;
    int ones = Integer.bitCount(k1 & Nones); // bitCount统计二进制中1的个数
    int cand = Integer.MAX_VALUE;
    if (n % 2 == 0 || ones * 2 < n) {
      cand = Math.min(cand, Integer.bitCount(k1 ^ 0xAAAAAAAA & Nones) / 2);
    }
    if (n % 2 == 0 || ones * 2 > n) {
      cand = Math.min(cand, Integer.bitCount(k1 ^ 0x55555555 & Nones) / 2);
    }
    return cand;
  }

}