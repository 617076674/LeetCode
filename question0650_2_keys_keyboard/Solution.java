package question0650_2_keys_keyboard;

/**
 * 最后一步操作一定是 Paste，因此最后几步操作一定是 Copy All, Paste, ..., Paste，
 * 每次 Paste 操作添加的 A 的数目和 Copy All 操作前记事本中 A 的数目相同。
 *
 * 状态定义：
 * dp[i] 表示打印出 i 个 A 的最少操作次数。
 *
 * 初始化条件：
 * dp[1] = 0。
 *
 * 状态转移方程：
 * dp[i] = dp[j] + i / j，其中 j 是 i 的最大约数。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：36.2MB，击败33.33%。
 */
public class Solution {

  public int minSteps(int n) {
    if (n == 1) {
      return 0;
    }
    for (int i = n - 1; i >= 1; i--) {
      if (n % i == 0) {
        return minSteps(i) + n / i;
      }
    }
    return -1;  //这一步不可能到达
  }

}