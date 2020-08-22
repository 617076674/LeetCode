package question1259_handshakes_that_dont_cross;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i] 表示 i 个人之见连线，不会相交的握手方案数。
 *
 * 初始化条件：
 * dp[0] = 1。
 *
 * 状态转移方程：
 * dp[i] = dp[j] * dp[i - j - 2], j ∈ [0, i) 且 j % 2 == 0。
 *
 * 时间复杂度是 O(num_people ^ 2)。空间复杂度是 O(num_people)。
 *
 * 执行用时：36ms，击败89.66%。消耗内存：36.3MB，击败96.15%。
 */
public class Solution2 {
  public int numberOfWays(int num_people) {
    long[] dp = new long[num_people + 1];
    int MOD = 1000000007;
    dp[0] = 1;
    for (int i = 2; i <= num_people; i += 2) {
      for (int j = 0; j < i; j += 2) {
        dp[i] += dp[j] * dp[i - j - 2];
        dp[i] %= MOD;
      }
    }
    return (int) dp[num_people];
  }
}