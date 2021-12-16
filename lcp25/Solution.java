package lcp25;

public class Solution {

  private static final int MOD = 1000000007;

  private int k;

  private Long[][] memo;

  private Long[][] combinationMemo;

  public int keyboard(int k, int n) {
    this.k = k;
    memo = new Long[n + 1][27];
    combinationMemo = new Long[n + 1][n + 1];
    return (int) keyboardHelper(n, 26);
  }

  /**
   * 使用编号为 keys 种按键总共按键 n 次，每个按键最多按 k 次，可以按出多少内容
   */
  private long keyboardHelper(int n, int keys) {
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return keys;
    }
    if (keys * k < n) {
      return 0;
    }
    if (memo[n][keys] != null) {
      return memo[n][keys];
    }
    long result = 0;
    // 第 keys 个按键可以按 [0, k] 次
    for (int i = 0; i <= Math.min(n, k); i++) {
      result += (combination(n, i) * keyboardHelper(n - i, keys - 1)) % MOD;
      result %= MOD;
    }
    memo[n][keys] = result;
    return result;
  }

  private long combination(int m, int n) {
    if (n == 0 || m == n) {
      return 1;
    }
    if (null != combinationMemo[m][n]) {
      return combinationMemo[m][n];
    }
    combinationMemo[m][n] = (combination(m - 1, n) + combination(m - 1, n - 1)) % MOD;
    return combinationMemo[m][n];
  }

}