package question0688_knight_probability_in_chessboard;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j][k]：从坐标(i, j)开始移动k次后仍然在棋盘上的概率。
 *
 * 状态转移：
 * dp[i][j][k] = (dp[i + 2][j + 1][k - 1] + dp[i + 2][j - 1][k - 1] + dp[i + 1][j + 2][k - 1] + dp[i + 1][j - 2][k - 1]
 *              + dp[i - 1][j + 2][k - 1] + dp[i - 1][j - 2][k - 1] + dp[i - 2][j + 1][k - 1] + dp[i - 2][j - 1][k - 1]) / 8.0。
 *
 * 时间复杂度和空间复杂度均是O(N * N * K)。
 *
 * 执行用时：9ms，击败29.35%。消耗内存：37.9MB，击败6.67%。
 */
public class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        double[][][] dp = new double[N + 4][N + 4][K + 1];
        for (int i = 0; i < N + 4; i++) {
            for (int j = 0; j < N + 4; j++) {
                if (i >= 2 && i <= N + 1 && j >= 2 && j <= N + 1) {
                    dp[i][j][0] = 1;
                }
            }
        }
        for (int k = 1; k <= K; k++) {
            for (int i = 2; i <= N + 1; i++) {
                for (int j = 2; j <= N + 1; j++) {
                    dp[i][j][k] = (dp[i + 2][j + 1][k - 1] + dp[i + 2][j - 1][k - 1] + dp[i + 1][j + 2][k - 1]
                            + dp[i + 1][j - 2][k - 1] + dp[i - 1][j + 2][k - 1] + dp[i - 1][j - 2][k - 1]
                            + dp[i - 2][j + 1][k - 1] + dp[i - 2][j - 1][k - 1]) / 8.0;
                }
            }
        }
        return dp[r + 2][c + 2][K];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().knightProbability(3, 2, 0, 0));
    }
}