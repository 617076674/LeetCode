package question0474_ones_and_zeroes;

public class Solution {

  private int[][] count01;

  private Integer[][][] memo;

  public int findMaxForm(String[] strs, int m, int n) {
    count01 = new int[strs.length][2];
    for (int i = 0; i < strs.length; i++) {
      for (int j = 0; j < strs[i].length(); j++) {
        char c = strs[i].charAt(j);
        if (c == '0') {
          count01[i][0]++;
        } else {
          count01[i][1]++;
        }
      }
    }
    memo = new Integer[strs.length][m + 1][n + 1];
    return findMaxFormHelper(strs.length - 1, m, n);
  }

  /**
   * 对于 strs 数组中 [0, index] 范围内的元素，最多允许有 m 个 0 和 n 个 1，最多能包含多少个元素。
   */
  private int findMaxFormHelper(int index, int m, int n) {
    if (m < 0 || n < 0) {
      return 0;
    }
    if (index == 0) {
      if (m < count01[0][0] || n < count01[0][1]) {
        return 0;
      }
      return 1;
    }
    if (memo[index][m][n] != null) {
      return memo[index][m][n];
    }
    memo[index][m][n] = 0;
    if (m >= count01[index][0] && n >= count01[index][1]) {
      // 包含第 index 个元素
      memo[index][m][n] = 1 +
          findMaxFormHelper(index - 1, m - count01[index][0], n - count01[index][1]);
    }
    // 不包含第 index 个元素
    memo[index][m][n] = Math.max(findMaxFormHelper(index - 1, m, n), memo[index][m][n]);
    return memo[index][m][n];
  }

}