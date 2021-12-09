package lcp04;

public class Solution {

  private int[] statusRow;

  private int m;

  private Integer[][] memo;

  public int domino(int n, int m, int[][] broken) {
    this.m = m;
    memo = new Integer[n + 1][1 << m];
    statusRow = new int[n + 1];
    statusRow[0] = (1 << m) - 1;
    for (int[] p : broken) {
      statusRow[p[0] + 1] ^= (1 << p[1]);
    }
    int result = 0;
    for (int status = 0; status < (1 << m); status++) {
      result = Math.max(result, dominoHelper(n - 1, status));
    }
    return result;
  }

  // 填充 [0, row] 行，第 row 行的状态是 status，能填充的最大数量
  private int dominoHelper(int row, int status) {
    if (row == -1) {
      return 0;
    }
    if ((status & (statusRow[row + 1])) != statusRow[row + 1]) {
      return Integer.MIN_VALUE;
    }
    if (null != memo[row][status]) {
      return memo[row][status];
    }
    int result = 0;
    for (int previousStatus = 0; previousStatus < (1 << m); previousStatus++) {
      if ((previousStatus & (statusRow[row])) == statusRow[row]) {
        int tempResult = 0;
        for (int i = 0; i < m; i++) {
          if ((status & (1 << i)) != 0 && (statusRow[row + 1] & (1 << i)) == 0) {
            // i 可能可以放
            if ((previousStatus & (1 << i)) != 0) {
              // 只能是横放
              if (i + 1 < m && (status & (1 << (i + 1))) != 0 && (statusRow[row + 1] & (1 << (i + 1))) == 0) {
                tempResult++;
                i++;
              }
            } else {
              tempResult++;
            }
          }
        }
        result = Math.max(result, tempResult + dominoHelper(row - 1, previousStatus));
      }
    }
    memo[row][status] = result;
    return result;
  }

}