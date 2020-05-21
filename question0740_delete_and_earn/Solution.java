package question0740_delete_and_earn;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][0] 表示对于 [0, i] 范围内的元素，取 i 所能获得的最大点数。
 * dp[i][1] 表示对于 [0, i] 范围内的元素，不取 i 所能获得的最大点数。
 *
 * 初始化条件：
 * dp[1][0] = map[1]。
 * dp[1][1] = 0。
 *
 * 状态转移方程：
 * dp[i][0] = max(dp[i - 1][1], dp[i - 2][0]) + map[i] * i。
 * dp[i][1] = max(dp[i - 1][0], dp[i - 1][1])。
 */
public class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] map = new int[10001];
        int max = 1;
        for (int num : nums) {
            map[num]++;
            max = Math.max(max, num);
        }
        int[][] dp = new int[max + 1][2];
        dp[1][0] = map[1];  // 取 1
        dp[1][1] = 0;   // 不取 1
        for (int i = 2; i < max + 1; i++) {
            dp[i][0] = Math.max(dp[i - 2][0], dp[i - 1][1]) + map[i] * i;  // 取 i
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        }
        return Math.max(dp[max][0], dp[max][1]);
    }
}