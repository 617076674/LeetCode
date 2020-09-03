package question1301_number_of_paths_with_max_score;

import java.util.List;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j][0] 表示到达 [i, j] 处，得分的最大值。
 * dp[i][j][1] 表示到达 [i, j] 处，得分为 dp[i][j][0] 的方案数。
 *
 * 初始化条件：
 * dp[n - 1][n - 1][0] = 0, 其中 n 为 board 列表的长度。
 * dp[n - 1][n - 1][1] = 1。
 *
 * 状态转移方程：
 * （1）如果 board.get(i).charAt(j) 是一个数字，若 max = max(dp[i + 1][j][0], dp[i][j + 1][0], dp[i + 1][j + 1][0]) 大于 0，
 * 取 dp[i][j][0] = max + board.get(i).charAt(j) - '0', dp[i][j][1] = dp[i + 1][j][1](可选) + dp[i][j + 1][1](可选) + dp[i + 1][j + 1][1](可选)，
 * 其中需要满足 max = dp[i + 1][j][1] 或 max = dp[i][j + 1][1] 或 max = dp[i + 1][j + 1][1]，才会考虑。
 * （2）如果 board.get(i).charAt(j) 不是一个数字，则只考虑为 'E' 的情况，和上述情况相同，只不过取 dp[i][j][0] = max。
 *
 * 时间复杂度和空间复杂度均是 O(n ^ 2)。
 *
 * 执行用时：16ms，击败63.41%。消耗内存：40.2MB，击败22.22%。
 */
public class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int[][] directions = {{1, 0}, {0, 1}, {1, 1}};
        int n = board.size();
        int[][][] dp = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = -1;
            }
        }
        dp[n - 1][n - 1][0] = 0;
        dp[n - 1][n - 1][1] = 1;
        int mod = 1000000007;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                char c = board.get(i).charAt(j);
                if (c == 'E' || (c >= '0' && c <= '9')) {
                    int max = -1;
                    for (int[] direction : directions) {
                        int newI = direction[0] + i, newJ = direction[1] + j;
                        if (newI < n && newJ < n) {
                            char pre = board.get(newI).charAt(newJ);
                            if (pre == 'S' || (pre >= '0' && pre <= '9')) {
                                max = Math.max(max, dp[newI][newJ][0]);
                            }
                        }
                    }
                    if (max != -1) {
                        dp[i][j][0] = max;
                        if (c != 'E') {
                            dp[i][j][0] += c - '0';
                        }
                        for (int[] direction : directions) {
                            int newI = direction[0] + i, newJ = direction[1] + j;
                            if (newI < n && newJ < n && max == dp[newI][newJ][0]) {
                                dp[i][j][1] += dp[newI][newJ][1];
                                dp[i][j][1] %= mod;
                            }
                        }
                    }
                }
            }
        }
        if (dp[0][0][0] < 0) {
            return new int[] {0, 0};
        }
        return dp[0][0];
    }
}