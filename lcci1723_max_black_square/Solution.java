package lcci1723_max_black_square;

/**
 * 动态规划。
 *
 * 时间复杂度是 O(n ^ 3)，其中 n 为 matrix 数组的长度。空间复杂度是 O(n ^ 2)。
 *
 * 执行用时：19ms，击败58.22%。消耗内存：48.1MB，击败100.00%。
 */
public class Solution {
    public int[] findSquare(int[][] matrix) {
        int n = matrix.length;
        int[][][] dp = new int[n][n][2];
        // dp[i][j][0] 表示 [i][j] 向右走的连续 0 个数
        // dp[i][j][1] 表示 [i][j] 向下走的连续 0 个数
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == 0) {
                    if (i != n - 1) {
                        dp[i][j][1] = dp[i + 1][j][1] + 1;
                    } else {
                        dp[i][j][1] = 1;
                    }
                    if (j != n - 1) {
                        dp[i][j][0] = dp[i][j + 1][0] + 1;
                    } else {
                        dp[i][j][0] = 1;
                    }
                }
            }
        }
        int[] result = new int[3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    int len = Math.min(dp[i][j][0], dp[i][j][1]);
                    while (len > 0) {
                        if (dp[i + len - 1][j][0] >= len && dp[i][j + len - 1][1] >= len) {
                            if (len > result[2]) {
                                result = new int[] {i, j, len};
                            }
                            break;
                        }
                        len--;
                    }
                }
            }
        }
        return result[2] == 0 ? new int[0] : result;
    }
}