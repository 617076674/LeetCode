package question0879_profitable_schemes;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j][k] 表示考虑第 [0, i - 1] 件犯罪事件，可用人数为 j，能获取利润大于等于 k 的事件组合数量。
 *
 * 初始化条件：
 * dp[0][0][0] = 1，即不考虑任何犯罪事件，没有任何人可用，利润大于等于 0 的事件组合数量为 1，即什么都不做。
 *
 * 状态转移方程：
 * dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - group[i - 1]][max(0, k - profit[i - 1])]。
 *
 * 事件复杂度和空间复杂度均是 O(G * P * group.length)。
 *
 * 执行用时：58ms，击败54.84%。消耗内存：48.8MB，击败14.29%。
 */
public class Solution {
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int MOD = 1000000007;
        int[][][] dp = new int[group.length + 1][G + 1][P + 1];
        dp[0][0][0] = 1;
        for (int i = 1; i < group.length + 1; i++) {
            for (int j = 0; j < G + 1; j++) {
                for (int k = 0; k < P + 1; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j - group[i - 1] >= 0) {
                        dp[i][j][k] += dp[i - 1][j - group[i - 1]][Math.max(0, k - profit[i - 1])];
                        dp[i][j][k] %= MOD;
                    }
                }
            }
        }
        int result = 0;
        for (int i = 0; i < G + 1; i++) {
            result += dp[group.length][i][P];
            result %= MOD;
        }
        return result;
    }
}