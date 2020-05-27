package question0935_knight_dialer;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j] 表示当前正在数字 i 上，还能够继续跳 j 步，能够拨出的号码个数。
 *
 * 初始化条件：
 * 当i != 5 时，dp[i][0] = 1。
 *
 * 状态转移方程：
 * dp[i][j] = sum(dp[next][j - 1]), 其中 next 为 i 能够跳一步到达的数字。
 *
 * 时间复杂度和空间复杂度均是 O(N)。
 *
 * 执行用时：54ms，击败42.06%。消耗内存：39.4MB，击败50.00%。
 */
public class Solution2 {
    private int[][] map = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};

    private static final int MOD = 1000000007;

    public int knightDialer(int N) {
        if (N == 1) {
            return 10;
        }
        int[][] dp = new int[10][N];
        for (int i = 0; i < 10; i++) {
            if (i != 5) {
                dp[i][0] = 1;
            }
        }
        for (int j = 1; j < N; j++) {
            for (int i = 0; i < 10; i++) {
                if (i != 5) {
                    for (int next : map[i]) {
                        dp[i][j] += dp[next][j - 1];
                        dp[i][j] %= MOD;
                    }
                }
            }
        }
        int result = 0;
        for (int i = 0; i < 10; i++) {
            if (i != 5) {
                result += dp[i][N - 1];
                result %= MOD;
            }
        }
        return result;
    }
}