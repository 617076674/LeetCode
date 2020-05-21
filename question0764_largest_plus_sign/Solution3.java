package question0764_largest_plus_sign;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j][0] 表示从 graph[i][j] 处往左推进，连续 0 的最大个数。
 * dp[i][j][1] 表示从 graph[i][j] 处往下推进，连续 0 的最大个数。
 * dp[i][j][2] 表示从 graph[i][j] 处往右推进，连续 0 的最大个数。
 * dp[i][j][3] 表示从 graph[i][j] 处往上推进，连续 0 的最大个数。
 *
 * 初始化条件：
 * 当 graph[i][0] != 1 时，dp[i][0][0] = 1。
 * 当 graph[N - 1][i] != 1 时，dp[N - 1][i][1] = 1。
 * 当 graph[i][N - 1] != 1 时，dp[i][N - 1][2] = 1。
 * 当 graph[0][i] != 1 时，dp[0][i][3] = 1。
 *
 * 状态转移方程：
 * 当 graph[i][j] != 1 时，
 * dp[i][j][0] = dp[i][j - 1][0] + 1
 * dp[i][j][1] = dp[i + 1][j][1] + 1
 * dp[i][j][2] = dp[i][j + 1][2] + 1
 * dp[i][j][3] = dp[i - 1][j][3] + 1
 *
 * 时间复杂度和空间复杂度均是 O(N ^ 2)。
 *
 * 执行用时：129ms，击败66.67%。消耗内存：65.7MB，击败100.00%。
 */
public class Solution3 {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] graph = new int[N][N];
        for (int[] mine : mines) {
            graph[mine[0]][mine[1]] = 1;
        }
        int[][][] dp = new int[N][N][4];
        for (int i = 0; i < N; i++) {
            if (graph[i][0] != 1) {
                dp[i][0][0] = 1;
            }
            if (graph[N - 1][i] != 1) {
                dp[N - 1][i][1] = 1;
            }
            if (graph[i][N - 1] != 1) {
                dp[i][N - 1][2] = 1;
            }
            if (graph[0][i] != 1) {
                dp[0][i][3] = 1;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (graph[i][j] != 1) {
                    dp[i][j][0] = dp[i][j - 1][0] + 1;
                }
            }
        }
        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] != 1) {
                    dp[i][j][1] = dp[i + 1][j][1] + 1;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = N - 2; j >= 0; j--) {
                if (graph[i][j] != 1) {
                    dp[i][j][2] = dp[i][j + 1][2] + 1;
                }
            }
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] != 1) {
                    dp[i][j][3] = dp[i - 1][j][3] + 1;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result = Math.max(result,
                        Math.min(dp[i][j][0], Math.min(dp[i][j][1], Math.min(dp[i][j][2], dp[i][j][3]))));
            }
        }
        return result;
    }
}